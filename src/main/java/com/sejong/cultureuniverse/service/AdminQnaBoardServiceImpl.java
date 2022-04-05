package com.sejong.cultureuniverse.service;

import com.sejong.cultureuniverse.dto.AdminQnaBoardDTO;
import com.sejong.cultureuniverse.dto.PageRequestDTO;
import com.sejong.cultureuniverse.dto.PageResultDTO;
import com.sejong.cultureuniverse.entity.admin.Qna;
import com.sejong.cultureuniverse.repository.AdminQnaBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class AdminQnaBoardServiceImpl implements AdminQnaBoardService{
    private final AdminQnaBoardRepository adminQnaBoardRepository;

    @Override
    public Long register(AdminQnaBoardDTO adminQnaBoardDTO) {
        log.info("adminQnaBoardDTO");
        log.info(adminQnaBoardDTO);
        Qna entity = dtoToEntity(adminQnaBoardDTO);
        log.info(entity);
        adminQnaBoardRepository.save(entity);
        return entity.getQuestionIdx();
    }

    @Override
    public PageResultDTO<AdminQnaBoardDTO, Qna> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("questionIdx").descending());
        Page<Qna> result = adminQnaBoardRepository.findAll(pageable);
        Function<Qna, AdminQnaBoardDTO> fn  = (entity->
            entityToDto(entity));
         return new PageResultDTO<>(result,fn);

    }

    @Override
    public void modify(AdminQnaBoardDTO dto) {
    Optional<Qna> result = adminQnaBoardRepository.findById(dto.getQuestionIdx());
    if(result.isPresent()){
        Qna entity = result.get();
        entity.changeTitle(dto.getTitle());
        entity.changeContent(dto.getContent());
        adminQnaBoardRepository.save(entity);
    }
    }

    @Override
    public AdminQnaBoardDTO read(Long questionIdx) {
        Optional<Qna> result = adminQnaBoardRepository.findById(questionIdx);
        return result.isPresent()? entityToDto(result.get()): null;
    }
}
