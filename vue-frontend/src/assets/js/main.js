"use strict";
jQuery(document).ready(function ($) {


    //==========================================
    //for Preloader
    //=========================================

    $(window).load(function () {
        $("#loading").fadeOut(500);
    });


    //==========================================
    // Mobile menu
    //=========================================
    $('#navbar-menu').find('a[href*="#"]:not([href="#"])').click(function () {
        if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                $('html,body').animate({
                    scrollTop: (target.offset().top - 80)
                }, 1000);
                if ($('.navbar-toggle').css('display') != 'none') {
                    $(this).parents('.container').find(".navbar-toggle").trigger("click");
                }
                return false;
            }
        }
    });



    //==========================================
    // wow
    //=========================================

    var wow = new WOW({
        mobile: false
    });
    wow.init();


// =========================================
// magnificPopup
// =========================================

    $('.popup-img').magnificPopup({
        type: 'image',
        gallery: {
            enabled: true
        }
    });

    $('.video-link').magnificPopup({
        type: 'iframe'
    });


// =========================================
//      featured slider
// =========================================


    $('.featured_slider').slick({
        centerMode: true,
        dote: true,
        centerPadding: '60px',
        slidesToShow: 3,
        speed: 1500,
        index: 2,
        responsive: [
            {
                breakpoint: 768,
                settings: {
                    arrows: false,
                    centerMode: true,
                    centerPadding: '40px',
                    slidesToShow: 1
                }
            },
            {
                breakpoint: 480,
                settings: {
                    arrows: false,
                    centerMode: true,
                    centerPadding: '40px',
                    slidesToShow: 1
                }
            }
        ]
    });



// =========================================
// Counter
// =========================================

    $('.statistic-counter').counterUp({
        delay: 10,
        time: 2000
    });



// =========================================
// Scroll Up
// =========================================

    $(window).scroll(function () {
        if ($(this).scrollTop() > 600) {
            $('.scrollup').fadeIn('slow');
        } else {
            $('.scrollup').fadeOut('slow');
        }
    });
    $('.scrollup').click(function () {
        $("html, body").animate({scrollTop: 0}, 1000);
        return false;
    });


// =========================================
// About us accordion
// =========================================

    $("#faq_main_content").collapse({
        accordion: true,
        open: function () {
            this.addClass("open");
            this.css({height: this.children().outerHeight()});
        },
        close: function () {
            this.css({height: "0px"});
            this.removeClass("open");
        }
    });

// =========================================
// Team Skillbar active js
// =========================================


    jQuery('.teamskillbar').each(function () {
        jQuery(this).find('.teamskillbar-bar').animate({
            width: jQuery(this).attr('data-percent')
        }, 6000);
    });






    //End

});

(function($) {

  "use strict";


  $(document).ready(function () {
    function c(passed_month, passed_year, calNum) {
      var calendar = calNum == 0 ? calendars.cal1 : calendars.cal2;
      makeWeek(calendar.weekline);
      calendar.datesBody.empty();
      var calMonthArray = makeMonthArray(passed_month, passed_year);
      var r = 0;
      var u = false;
      while (!u) {
        if (daysArray[r] == calMonthArray[0].weekday) {
          u = true;
        } else {
          calendar.datesBody.append('<div class="blank"></div>');
          r++;
        }
      }
      for (var cell = 0; cell < 42 - r; cell++) { // 42 date-cells in calendar
        if (cell >= calMonthArray.length) {
          calendar.datesBody.append('<div class="blank"></div>');
        } else {
          var shownDate = calMonthArray[cell].day;
          var iter_date = new Date(passed_year, passed_month, shownDate);
          if (
            (
              (shownDate != today.getDate() && passed_month == today.getMonth()) || passed_month != today.getMonth()) && iter_date < today) {
            var m = '<div class="past-date">';
          } else {
            var m = checkToday(iter_date) ? '<div class="today">' : "<div>";
          }
          calendar.datesBody.append(m + shownDate + "</div>");
        }
      }

      var color = "#444444";
      calendar.calHeader.find("h2").text(i[passed_month] + " " + passed_year);
      calendar.weekline.find("div").css("color", color);
      calendar.datesBody.find(".today").css("color", "#00bdaa");

      // find elements (dates) to be clicked on each time
      // the calendar is generated
      var clicked = false;
      selectDates(selected);

      clickedElement = calendar.datesBody.find('div');
      clickedElement.on("click", function () {
        clicked = $(this);
        var whichCalendar = calendar.name;

        if (firstClick && secondClick) {
          thirdClicked = getClickedInfo(clicked, calendar);
          var firstClickDateObj = new Date(firstClicked.year,
            firstClicked.month,
            firstClicked.date);
          var secondClickDateObj = new Date(secondClicked.year,
            secondClicked.month,
            secondClicked.date);
          var thirdClickDateObj = new Date(thirdClicked.year,
            thirdClicked.month,
            thirdClicked.date);
          if (secondClickDateObj > thirdClickDateObj && thirdClickDateObj > firstClickDateObj) {
            secondClicked = thirdClicked;
            // then choose dates again from the start :)
            bothCals.find(".calendar_content").find("div").each(function () {
              $(this).removeClass("selected");
            });
            selected = {};
            selected[firstClicked.year] = {};
            selected[firstClicked.year][firstClicked.month] = [firstClicked.date];
            selected = addChosenDates(firstClicked, secondClicked, selected);
          } else { // reset clicks
            selected = {};
            firstClicked = [];
            secondClicked = [];
            firstClick = false;
            secondClick = false;
            bothCals.find(".calendar_content").find("div").each(function () {
              $(this).removeClass("selected");
            });
          }
        }
        if (!firstClick) {
          firstClick = true;
          firstClicked = getClickedInfo(clicked, calendar);
          selected[firstClicked.year] = {};
          selected[firstClicked.year][firstClicked.month] = [firstClicked.date];
        } else {
          secondClick = true;
          secondClicked = getClickedInfo(clicked, calendar);

          // what if second clicked date is before the first clicked?
          var firstClickDateObj = new Date(firstClicked.year,
            firstClicked.month,
            firstClicked.date);
          var secondClickDateObj = new Date(secondClicked.year,
            secondClicked.month,
            secondClicked.date);

          if (firstClickDateObj > secondClickDateObj) {

            var cachedClickedInfo = secondClicked;
            secondClicked = firstClicked;
            firstClicked = cachedClickedInfo;
            selected = {};
            selected[firstClicked.year] = {};
            selected[firstClicked.year][firstClicked.month] = [firstClicked.date];

          } else if (firstClickDateObj.getTime() == secondClickDateObj.getTime()) {
            selected = {};
            firstClicked = [];
            secondClicked = [];
            firstClick = false;
            secondClick = false;
            $(this).removeClass("selected");
          }


          // add between dates to [selected]
          selected = addChosenDates(firstClicked, secondClicked, selected);
        }
        selectDates(selected);
      });

    }

    function selectDates(selected) {
      if (!$.isEmptyObject(selected)) {
        var dateElements1 = datesBody1.find('div');
        var dateElements2 = datesBody2.find('div');

        function highlightDates(passed_year, passed_month, dateElements) {
          if (passed_year in selected && passed_month in selected[passed_year]) {
            var daysToCompare = selected[passed_year][passed_month];
            for (var d in daysToCompare) {
              dateElements.each(function (index) {
                if (parseInt($(this).text()) == daysToCompare[d]) {
                  $(this).addClass('selected');
                }
              });
            }

          }
        }

        highlightDates(year, month, dateElements1);
        highlightDates(nextYear, nextMonth, dateElements2);
      }
    }

    function makeMonthArray(passed_month, passed_year) { // creates Array specifying dates and weekdays
      var e = [];
      for (var r = 1; r < getDaysInMonth(passed_year, passed_month) + 1; r++) {
        e.push({
          day: r,
          // Later refactor -- weekday needed only for first week
          weekday: daysArray[getWeekdayNum(passed_year, passed_month, r)]
        });
      }
      return e;
    }

    function makeWeek(week) {
      week.empty();
      for (var e = 0; e < 7; e++) {
        week.append("<div>" + daysArray[e].substring(0, 3) + "</div>")
      }
    }

    function getDaysInMonth(currentYear, currentMon) {
      return (new Date(currentYear, currentMon + 1, 0)).getDate();
    }

    function getWeekdayNum(e, t, n) {
      return (new Date(e, t, n)).getDay();
    }

    function checkToday(e) {
      var todayDate = today.getFullYear() + '/' + (today.getMonth() + 1) + '/' + today.getDate();
      var checkingDate = e.getFullYear() + '/' + (e.getMonth() + 1) + '/' + e.getDate();
      return todayDate == checkingDate;

    }

    function getAdjacentMonth(curr_month, curr_year, direction) {
      var theNextMonth;
      var theNextYear;
      if (direction == "next") {
        theNextMonth = (curr_month + 1) % 12;
        theNextYear = (curr_month == 11) ? curr_year + 1 : curr_year;
      } else {
        theNextMonth = (curr_month == 0) ? 11 : curr_month - 1;
        theNextYear = (curr_month == 0) ? curr_year - 1 : curr_year;
      }
      return [theNextMonth, theNextYear];
    }

    function b() {
      today = new Date;
      year = today.getFullYear();
      month = today.getMonth();
      var nextDates = getAdjacentMonth(month, year, "next");
      nextMonth = nextDates[0];
      nextYear = nextDates[1];
    }

    var e = 480;

    var today;
    var year,
      month,
      nextMonth,
      nextYear;

    var r = [];
    var i = [
      "January",
      "Feburary",
      "March",
      "April",
      "May",
      "June",
      "July",
      "August",
      "September",
      "October",
      "November",
      "December"];
    var daysArray = [
      "Sunday",
      "Monday",
      "Tuesday",
      "Wednesday",
      "Thursday",
      "Friday",
      "Saturday"];

    var cal1 = $("#calendar_first");
    var calHeader1 = cal1.find(".calendar_header");
    var weekline1 = cal1.find(".calendar_weekdays");
    var datesBody1 = cal1.find(".calendar_content");

    var cal2 = $("#calendar_second");
    var calHeader2 = cal2.find(".calendar_header");
    var weekline2 = cal2.find(".calendar_weekdays");
    var datesBody2 = cal2.find(".calendar_content");

    var bothCals = $(".calendar");

    var switchButton = bothCals.find(".calendar_header").find('.switch-month');

    var calendars = {
      "cal1": {
        "name": "first",
        "calHeader": calHeader1,
        "weekline": weekline1,
        "datesBody": datesBody1
      },
      "cal2": {
        "name": "second",
        "calHeader": calHeader2,
        "weekline": weekline2,
        "datesBody": datesBody2
      }
    }


    var clickedElement;
    var firstClicked,
      secondClicked,
      thirdClicked;
    var firstClick = false;
    var secondClick = false;
    var selected = {};

    b();
    c(month, year, 0);
    c(nextMonth, nextYear, 1);
    switchButton.on("click", function () {
      var clicked = $(this);
      var generateCalendars = function (e) {
        var nextDatesFirst = getAdjacentMonth(month, year, e);
        var nextDatesSecond = getAdjacentMonth(nextMonth, nextYear, e);
        month = nextDatesFirst[0];
        year = nextDatesFirst[1];
        nextMonth = nextDatesSecond[0];
        nextYear = nextDatesSecond[1];

        c(month, year, 0);
        c(nextMonth, nextYear, 1);
      };
      if (clicked.attr("class").indexOf("left") != -1) {
        generateCalendars("previous");
      } else {
        generateCalendars("next");
      }
      clickedElement = bothCals.find(".calendar_content").find("div");
    });


    //  Click picking stuff
    function getClickedInfo(element, calendar) {
      var clickedInfo = {};
      var clickedCalendar,
        clickedMonth,
        clickedYear;
      clickedCalendar = calendar.name;
      clickedMonth = clickedCalendar == "first" ? month : nextMonth;
      clickedYear = clickedCalendar == "first" ? year : nextYear;
      clickedInfo = {
        "calNum": clickedCalendar,
        "date": parseInt(element.text()),
        "month": clickedMonth,
        "year": clickedYear
      }
      return clickedInfo;
    }


    // Finding between dates MADNESS. Needs refactoring and smartening up :)
    function addChosenDates(firstClicked, secondClicked, selected) {
      if (secondClicked.date > firstClicked.date || secondClicked.month > firstClicked.month || secondClicked.year > firstClicked.year) {

        var added_year = secondClicked.year;
        var added_month = secondClicked.month;
        var added_date = secondClicked.date;

        if (added_year > firstClicked.year) {
          // first add all dates from all months of Second-Clicked-Year
          selected[added_year] = {};
          selected[added_year][added_month] = [];
          for (var i = 1;
            i <= secondClicked.date;
            i++) {
            selected[added_year][added_month].push(i);
          }

          added_month = added_month - 1;
          while (added_month >= 0) {
            selected[added_year][added_month] = [];
            for (var i = 1;
              i <= getDaysInMonth(added_year, added_month);
              i++) {
              selected[added_year][added_month].push(i);
            }
            added_month = added_month - 1;
          }

          added_year = added_year - 1;
          added_month = 11; // reset month to Dec because we decreased year
          added_date = getDaysInMonth(added_year, added_month); // reset date as well

          // Now add all dates from all months of inbetween years
          while (added_year > firstClicked.year) {
            selected[added_year] = {};
            for (var i = 0; i < 12; i++) {
              selected[added_year][i] = [];
              for (var d = 1; d <= getDaysInMonth(added_year, i); d++) {
                selected[added_year][i].push(d);
              }
            }
            added_year = added_year - 1;
          }
        }

        if (added_month > firstClicked.month) {
          if (firstClicked.year == secondClicked.year) {
            selected[added_year][added_month] = [];
            for (var i = 1;
              i <= secondClicked.date;
              i++) {
              selected[added_year][added_month].push(i);
            }
            added_month = added_month - 1;
          }
          while (added_month > firstClicked.month) {
            selected[added_year][added_month] = [];
            for (var i = 1;
              i <= getDaysInMonth(added_year, added_month);
              i++) {
              selected[added_year][added_month].push(i);
            }
            added_month = added_month - 1;
          }
          added_date = getDaysInMonth(added_year, added_month);
        }

        for (var i = firstClicked.date + 1;
          i <= added_date;
          i++) {
          selected[added_year][added_month].push(i);
        }
      }
      return selected;
    }
  });


})(jQuery);



// =========================================
//  Portfolio Isotop
// =========================================

$(function () {
    // Initialize Isotope
    var $notes = $(".grid").isotope({
        itemSelector: ".grid-item"
    });

    // On filter button click
    $(".filters-button-group .button").on("click", function (e) {
        var $this = $(this);

        // Prevent default behaviour
        e.preventDefault();

        // Toggle the active class on the correct button
        $(".filters-button-group .button").removeClass("is-checked");
        $this.addClass("is-checked");

        // Get the filter data attribute from the button
        $notes.isotope({
            filter: $this.attr("data-filter")
        });

    });
});
















