// 장바구니!
// 장바구니 관련 요소 찾기.
const basketStarterEl = document.querySelector('header .basket-starter')
const basketEl = basketStarterEl.querySelector('.basket')

basketStarterEl.addEventListener('click', event => {
  event.stopPropagation() // 이벤트 버블링 정지! - 버튼을 클릭했을 때 드롭다운 메뉴가 나타나야 함.
  if (basketEl.classList.contains('show')) {
    hideBasket()
  } else {
    showBasket()
  }
})
basketEl.addEventListener('click', event => {
  event.stopPropagation() // 이벤트 버블링 정지! - 드롭다운 메뉴 영역을 클릭했을 때 메뉴가 사라지지 않아야 함.
})
// 화면 전체를 클릭했을 때 메뉴가 사라짐.
window.addEventListener('click', () => {
  hideBasket()
})

// 특정 로직을 직관적인 함수 이름으로 묶음.
function showBasket() {
  basketEl.classList.add('show')
}
function hideBasket() {
  basketEl.classList.remove('show')
}


// 헤더 검색!
// 헤더 검색 관련 요소 찾기.
const headerEl = document.querySelector('header')
const headerMenuEls = [...headerEl.querySelectorAll('ul.menu > li')]
const searchWrapEl = headerEl.querySelector('.search-wrap')
const searchStarterEl = headerEl.querySelector('.search-starter')
const searchCloserEl = searchWrapEl.querySelector('.search-closer')
const searchShadowEl = searchWrapEl.querySelector('.shadow')
const searchInputEl = searchWrapEl.querySelector('input')
const searchDelayEls = [...searchWrapEl.querySelectorAll('li')]
const duration = .4 // 초(seconds) 단위, 시간을 변수에 저장해서 사용하면 쉽게 관리 용이

searchStarterEl.addEventListener('click', showSearch)
searchCloserEl.addEventListener('click', event => {
  event.stopPropagation() // 데스크탑 레이아웃에서 클릭 이벤트가 버블링되어, 모바일 레이아웃에서 searchTextFieldEl가 클릭된 상태로 변하는 것을 방지
  hideSearch()
})
searchShadowEl.addEventListener('click', hideSearch)

function showSearch() {
  headerEl.classList.add('searching')
  stopScroll()
  headerMenuEls.reverse().forEach((el, index) => {
    el.style.transitionDelay = `${index * duration / headerMenuEls.length}s` // 순서 * 지연 시간 / 애니메이션할 요소 개수
  })
  // .reverse() 사용하지 않고 원래 순서대로 반복 처리.
  searchDelayEls.forEach((el, index) => {
    el.style.transitionDelay = `${index * duration / searchDelayEls.length}s`
  })
  // 검색 인풋 요소가 나타난 후 동작!
  setTimeout(() => {
    searchInputEl.focus()
  }, 600);
}
function hideSearch() {
  headerEl.classList.remove('searching')
  playScroll()
  headerMenuEls.reverse().forEach((el, index) => {
    el.style.transitionDelay = `${index * duration / headerMenuEls.length}s`
  })
  searchDelayEls.reverse().forEach((el, index) => {
    el.style.transitionDelay = `${index * duration / searchDelayEls.length}s`
  })
  searchDelayEls.reverse() // 나타날 때 원래의 순서대로 처리해야 하기 때문에 다시 뒤집어서 순서 돌려놓기!
  searchInputEl.value = '' // 입력값 초기화
}

// 헤더 메뉴 토글! [모바일]
const menuStarterEl = document.querySelector('header .menu-starter')
menuStarterEl.addEventListener('click', () => {
  if (headerEl.classList.contains('menuing')) {
    headerEl.classList.remove('menuing')
    searchInputEl.value = ''
    playScroll()
  } else {
    headerEl.classList.add('menuing')
    stopScroll()
  }
})

// 헤더 검색! [모바일]
const searchTextFieldEl = document.querySelector('header .textfield')
const searchCancelEl = document.querySelector('header .search-canceler')
searchTextFieldEl.addEventListener('click', () => {
  headerEl.classList.add('searching--mobile')
  searchInputEl.focus()
})
searchCancelEl.addEventListener('click', () => {
  headerEl.classList.remove('searching--mobile')
})

// 화면 크기가 달라졌을 때 검색 모드가 종료되도록 처리.
window.addEventListener('resize', event => {
  if (window.innerWidth <= 740) {
    headerEl.classList.remove('searching')
  } else {
    headerEl.classList.remove('searching--mobile')
  }
})


// 네비게이션 메뉴 토글! [모바일]
const navEl = document.querySelector('nav')
const navMenuToggleEl = navEl.querySelector('.menu-toggler')
const navMenuShadowEl = navEl.querySelector('.shadow')
navMenuToggleEl.addEventListener('click', () => {
  if (navEl.classList.contains('menuing')) {
    hideNavMenu()
  } else {
    showNavMenu()
  }
})
navEl.addEventListener('click', event => {
  event.stopPropagation()
})
navMenuShadowEl.addEventListener('click', hideNavMenu)
window.addEventListener('click', hideNavMenu)
function showNavMenu() {
  navEl.classList.add('menuing')
}
function hideNavMenu() {
  navEl.classList.remove('menuing')
}


// 요소의 가시성 관찰 로직!
const io = new IntersectionObserver(entries => {
  // entries는 `io.observe(el)`로 등록된 모든 관찰 대상 배열.
  entries.forEach(entry => {
    // 사라질 때.
    if (!entry.isIntersecting) {
      return
    }
    entry.target.classList.add('show')
  })
})

/**
 * 슬라이드 요소 관리
 */
new Swiper('.notice-line .swiper-container', {
  direction: 'vertical', // 수직 슬라이드
  autoplay: true, // 자동 재생 여부
  loop: true // 반복 재생 여부
})
new Swiper('.promotion .swiper-container', {
  // direction: 'horizontal', // 수평 슬라이드
  autoplay: { // 자동 재생 여부
    delay: 5000 // 5초마다 슬라이드 바뀜
  },
  loop: true, // 반복 재생 여부
  slidesPerView: 3, // 한 번에 보여줄 슬라이드 개수
  spaceBetween: 10, // 슬라이드 사이 여백
  centeredSlides: true, // 1번 슬라이드가 가운데 보이기
  pagination: { // 페이지 번호 사용 여부
    el: '.promotion .swiper-pagination', // 페이지 번호 요소 선택자
    clickable: true // 사용자의 페이지 번호 요소 제어 가능 여부
  },
  navigation: { // 슬라이드 이전/다음 버튼 사용 여부
    prevEl: '.promotion .swiper-prev', // 이전 버튼 선택자
    nextEl: '.promotion .swiper-next' // 다음 버튼 선택자
  }
})
new Swiper('.awards .swiper-container', {
  // direction: 'horizontal', // 수평 슬라이드
  autoplay: true, // 자동 재생 여부
  loop: true, // 반복 재생 여부
  spaceBetween: 30, // 슬라이드 사이 여백
  slidesPerView: 5, // 한 번에 보여줄 슬라이드 개수
  // slidesPerGroup: 5, // 한 번에 슬라이드 할 개수(전체 개수로 나뉘어야 함)
  navigation: { // 슬라이드 이전/다음 버튼 사용 여부
    prevEl: '.awards .swiper-prev', // 이전 버튼 선택자
    nextEl: '.awards .swiper-next' // 다음 버튼 선택자
  }
})


var intersectionObserver = new IntersectionObserver(function(entries) {
  if (entries[0].intersectionRatio <= 0) return;

  loadItems(8);
});
// start observing
intersectionObserver.observe(document.querySelector('.temp'));

function loadItems(count) {
  let temp = document.querySelector('.content-container');
  let template = document.getElementById('test').innerText;
  for(let i = 0; i < count; i++) {
    temp.insertAdjacentHTML('beforeend', template);
  }
  // let template = document.getElementById("ticket_box").innerText;
  // let bindTemplate = Handlebars.compile(template);
  //
  // let innerHtml = this.data.productPrices.reduce(function (prve, next) {
  //   next.price = Number(next.price).toLocaleString();
  //   return prve + bindTemplate(next);
  // }, "");
}

// Main

document,addEventListener("DOMContentLoaded", function() {
  let currentCategoryId = 0;
  printPage(0, currentCategoryId);
  printPromotions();
});

let currentCategoryId = 0;

function sendAjax(url, callBack) {
  let oReq = new XMLHttpRequest();
  oReq.addEventListener("load", function () {
    let response = JSON.parse(oReq.responseText);
    callBack(response);
  });
  oReq.open("GET", url);
  oReq.send();
}

function printPage(start, categoryId) {
  let displayInfoRequestUrl;
  if(categoryId == 0) {
    displayInfoRequestUrl = `http://localhost:8080/api/products?cursor=${start}`;
  } else {
    displayInfoRequestUrl = `http://localhost:8080/api/products?cursor=${start}&categoryId=${categoryId}`;
  }
  // let template = document.getElementById("itemList").innerText;
  // let container = document.querySelectorAll(".lst_event_box");

  sendAjax(displayInfoRequestUrl, function(response) {
    console.log(response);
    if(start === 0) {
      printTotalCount(response.totalCount);
    }
    if(response.totalCount - start <= 4) {
      document.querySelector(".btn").style.display = "none";
    }
    let resultHtml = "";
    let count = 0;
    Object.keys(response.items).forEach(function(key) {
      resultHtml = template.replace("{displayInfoId}",response.items[key].displayInfoId)
          .replace("{productDescription}", response.items[key].productDescription)
          .replace("{title}", response.items[key].productDescription)
          .replace("{fileId}", response.items[key].fileId)
          .replace("{placeName}", response.items[key].placeName)
          .replace("{productContent}", response.items[key].productContent);
      ++count;

      if(count % 2 === 0) {
        container[1].insertAdjacentHTML("beforeend", resultHtml);
      } else {
        container[0].insertAdjacentHTML("beforeend", resultHtml);
      }
    });
  });
}

function printTotalCount(totalCount) {
  document.querySelector(".pink").innerText = `${totalCount}개`;
}

let clickCount = 0;
document.querySelector(".btn").addEventListener("click", function() {
  clickCount++;
  let start = clickCount * 4;
  printPage(start, currentCategoryId);
});

function printPromotions() {
  let template = document.getElementById("promotionItem").innerText;
  let resultHtml= "";
  const promotionRequestUrl = `http://localhost:8080/api/promotions`;
  sendAjax(promotionRequestUrl, function(response) {
    Object.keys(response.items).forEach(function(key) {
      resultHtml += template.replace("{fileId}", response.items[key].fileId);
    });
    document.querySelector(".visual_img").innerHTML = resultHtml;
    initImageSlide();
  });
}

// document.querySelector(".event_tab_lst").addEventListener("click", function(evt) {
//   resetTabCss();
//
//   if(evt.target.tagName === "LI") {
//     currentCategoryId = evt.target.dataset.category;
//     evt.target.querySelector(".anchor").classList.add("active");
//
//   } else if(evt.target.tagName === "A") {
//     currentCategoryId = evt.target.parentNode.dataset.category;
//     evt.target.classList.add("active");
//
//   } else if(evt.target.tagName === "SPAN") {
//     currentCategoryId = evt.target.parentNode.parentNode.dataset.category;
//     evt.target.closest(".anchor").classList.add("active");
//
//   }
//
//   let container = document.querySelectorAll(".lst_event_box");
//   container.forEach(function(target){
//     target.innerHTML = "";
//   });
//   document.querySelector(".btn").style.display = "block";
//   clickCount = 0;
//   let start = clickCount;
//   printPage(start, currentCategoryId);
// });
//
// function initImageSlide() {
//   let img_slide_ul = document.querySelector('.visual_img');
//   let firstProduct = img_slide_ul.firstElementChild.cloneNode(true);
//
//   img_slide_ul.appendChild(firstProduct);
//
//   let index = 0;
//   setInterval(function() {
//     let pre = parseInt(img_slide_ul.style.right);
//     img_slide_ul.style.transition = ".3s"
//     img_slide_ul.style.right = pre + 414 + "px";
//     index++;
//     if(index == 11) {
//       setTimeout(function(){
//         img_slide_ul.style.transition = "0s";
//         img_slide_ul.style.right = 0 + "px";
//       }, 3001)
//       index = 0;
//     }
//   } ,4000)
//
// }
//
// function resetTabCss() {
//   let tablinks = document.getElementsByClassName("anchor");
//   for (let i = 0; i < tablinks.length; i++) {
//     tablinks[i].className = tablinks[i].className.replace("active", "");
//   }
// }

sendAjax(`/api/categories`, function(response) {
  console.log(response);
});
