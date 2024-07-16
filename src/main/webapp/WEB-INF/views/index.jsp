<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Ticket Take it!</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
            href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&family=Roboto:wght@400;500;700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <!--Swiper-->
    <link rel="stylesheet" href="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.css" />
    <script src="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.js"></script>
    <link rel="stylesheet" href="/css/main.css" />
    <script defer type="module" src="/js/main.js"></script>
</head>

<body>
<!-- Header -->
<header>
    <div class="inner">

        <ul class="menu">
            <li class="menu-starter">
                <a>
                    <div>
                        <span></span>
                        <span></span>
                    </div>
                </a>
            </li>
            <li><a href="javascript:void(0)">Home</a></li>
            <li><a href="javascript:void(0)">예약 조회</a></li>
            <li><a href="javascript:void(0)">로그인/회원가입</a></li>
            <li class="search-starter"><a href="javascript:void(0)">검색</a></li>
            <li class="basket-starter">
                <a href="javascript:void(0)">장바구니</a>
                <div class="basket">
                    <div class="arrow"></div>
                    <div class="message">
                        장바구니가 비어 있습니다.
                    </div>
                </div>
            </li>
        </ul>

        <div class="search-wrap">
            <div class="search">
                <div class="shadow"></div>
                <div class="textfield">
                    <input type="text" placeholder="검색" />
                    <div class="search-icon"></div>
                    <div class="search-closer"></div>
                </div>
                <div class="search-canceler">취소</div>
                <div class="autocompletes">
                    <h3>빠른 링크</h3>
                    <ul>

                    </ul>
                </div>
            </div>
        </div>

        <div class="clone-menu">
            <ul>
                <li><a href="javascript:void(0)">스토어</a></li>
                <li><a href="javascript:void(0)">Mac</a></li>
                <li><a href="javascript:void(0)">iPad</a></li>
                <li><a href="javascript:void(0)">iPhone</a></li>
                <li><a href="javascript:void(0)">Watch</a></li>
                <li><a href="javascript:void(0)">AirPods</a></li>
                <li><a href="javascript:void(0)">TV 및 홈</a></li>
                <li><a href="javascript:void(0)">Apple 독점 제공</a></li>
                <li><a href="javascript:void(0)">액세서리</a></li>
                <li><a href="javascript:void(0)">고객지원</a></li>
            </ul>
        </div>
    </div>
</header>


<!-- Navigation -->
<nav>
    <div class="shadow"></div>
    <div class="contents-bg"></div>
    <div class="inner">

        <h1><a href="">Ticket Take it</a></h1>
        <div class="menu-toggler"></div>
        <ul class="menu">
        </ul>

    </div>
</nav>

<!-- Promotion -->
<div class="promotion">

    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide">
                <img src="./images/promotion_slide1.jpg" alt="2021 뉴이어, 스타벅스와 함께 즐겁고 활기차게 시작하세요!" />
                <a href="javascript:void(0)" class="btn">자세히 보기</a>
            </div>
            <div class="swiper-slide">
                <img src="./images/promotion_slide2.jpg" alt="기간 내 스타벅스 카드 e-Gift를 3만원 이상 선물 시, 아메리카노 e-쿠폰을 드립니다." />
                <a href="javascript:void(0)" class="btn">자세히 보기</a>
            </div>
            <div class="swiper-slide">
                <img src="./images/promotion_slide3.jpg" alt="뉴이어 푸드와 제조 음료를 세트로 구매 시, 뉴이어 음료 BOGO(1+1) 쿠폰을 드립니다." />
                <a href="javascript:void(0)" class="btn">자세히 보기</a>
            </div>
            <div class="swiper-slide">
                <img src="./images/promotion_slide4.jpg" alt="신년 MD 상품 포함 3만원 이상 구매 고객께 아메리카노(톨사이즈) 쿠폰을 드립니다." />
                <a href="javascript:void(0)" class="btn">자세히 보기</a>
            </div>
            <div class="swiper-slide">
                <img src="./images/promotion_slide5.jpg" alt="2017 DIGITAL LUCKY DRAW 100% 당첨의 행운을 드립니다!" />
                <a href="javascript:void(0)" class="btn">자세히 보기</a>
            </div>
        </div>
    </div>

    <div class="swiper-pagination"></div>

    <div class="swiper-prev">
        <span class="material-icons">arrow_back</span>
    </div>
    <div class="swiper-next">
        <span class="material-icons">arrow_forward</span>
    </div>
</div>

<div class="main">
    <div class="display-intro">
        <p>나만 뒤쳐지는 게 아닌가 걱정되신다구요?</p>
        <p class="display-main-text"><span class="highlight">Ticket Take it</span>과 함께 매일 성장해요</p>
    </div>
    <ul class="category">
        <li><a href="">전체</a></li>
        <li><a href="">밋업</a></li>
        <li><a href="">Web</a></li>
        <li><a href="">AI</a></li>
        <li><a href="">CS</a></li>
    </ul>
    <div class="content-wraper">
        <ul class="content-container">
            <li class="card">
                <a href="">
                    <div>
                        <img class="card-image" src="./images/썸네일.png" alt="">
                    </div>
                    <div class="card-text">
                        <strong class="card-title">[오프라인] 최고민수야 고맙다! 주식 Master Class</strong>
                        <p class="card-content">다양한 분야에 능통한 최고민수가 '주식'의 B4용지를 모든 분들에게 전수합니다!</p>
                    </div>
                    <ul class="card-tags">
                        <li class="card-tag">주식</li>
                        <li class="card-tag">최고민수</li>
                        <li class="card-tag">주식투자</li>
                        <li class="card-tag">투자</li>
                    </ul>
                </a>
            </li>
            <li class="card">
                <a href="">
                    <div>
                        <img class="card-image" src="./images/thumb123.jpg" alt="">
                    </div>
                    <div class="card-text">
                        <strong class="card-title">벡터DB로 구현하는 LLM 기반 검색 엔진 & 유사 상품 추천 시스템 (ft....)</strong>
                        <p class="card-content">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel voluptatum ducimus
                            aspernatur ipsam sit mollitia dolorem architecto, accusamus ad cum fuga deleniti nam aperiam, nobis
                            excepturi. Consequatur dolores obcaecati dignissimos?</p>
                    </div>
                    <ul class="card-tags">
                        <li class="card-tag">벡터db</li>
                        <li class="card-tag">벡터데이터베이스</li>
                        <li class="card-tag">벡터임베딩</li>
                    </ul>
                </a>
            </li>
            <li class="card">
                <a href="">
                    <div>
                        <img class="card-image" src="./images/thumb--3-.jpg" alt="">
                    </div>
                    <div class="card-text">
                        <strong class="card-title">TEST!</strong>
                        <p class="card-content">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel voluptatum ducimus
                            aspernatur ipsam sit mollitia dolorem architecto, accusamus ad cum fuga deleniti nam aperiam, nobis
                            excepturi. Consequatur dolores obcaecati dignissimos?</p>
                    </div>
                    <ul class="card-tags">
                        <li class="card-tag">tag1</li>
                        <li class="card-tag">tag2</li>
                        <li class="card-tag">tag3</li>
                    </ul>
                </a>
            </li>
            <li class="card">
                <a href="">
                    <div>
                        <img class="card-image" src="./images/브릿지-썸네일.png" alt="">
                    </div>
                    <div class="card-text">
                        <strong class="card-title">TEST!</strong>
                        <p class="card-content">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel voluptatum ducimus
                            aspernatur ipsam sit mollitia dolorem architecto, accusamus ad cum fuga deleniti nam aperiam, nobis
                            excepturi. Consequatur dolores obcaecati dignissimos?</p>
                    </div>
                    <ul class="card-tags">
                        <li class="card-tag">tag1</li>
                        <li class="card-tag">tag2</li>
                        <li class="card-tag">tag3</li>
                    </ul>
                </a>
            </li>
            <li class="card">
                <a href="">
                    <div>
                        <img class="card-image" src="./images/thumb--3-.jpg" alt="">
                    </div>
                    <div class="card-text">
                        <strong class="card-title">TEST!</strong>
                        <p class="card-content">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel voluptatum ducimus
                            aspernatur ipsam sit mollitia dolorem architecto, accusamus ad cum fuga deleniti nam aperiam, nobis
                            excepturi. Consequatur dolores obcaecati dignissimos?</p>
                    </div>
                    <ul class="card-tags">
                        <li class="card-tag">tag1</li>
                        <li class="card-tag">tag2</li>
                        <li class="card-tag">tag3</li>
                    </ul>
                </a>
            </li>
            <li class="card">
                <a href="">
                    <div>
                        <img class="card-image" src="./images/시그니처---백엔드-1.png" alt="">
                    </div>
                    <div class="card-text">
                        <strong class="card-title">TEST!</strong>
                        <p class="card-content">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel voluptatum ducimus
                            aspernatur ipsam sit mollitia dolorem architecto, accusamus ad cum fuga deleniti nam aperiam, nobis
                            excepturi. Consequatur dolores obcaecati dignissimos?</p>
                    </div>
                    <ul class="card-tags">
                        <li class="card-tag">tag1</li>
                        <li class="card-tag">tag2</li>
                        <li class="card-tag">tag3</li>
                    </ul>
                </a>
            </li>
            <li class="card">
                <a href="">
                    <div>
                        <img class="card-image" src="./images/시그니처---백엔드-1.png" alt="">
                    </div>
                    <div class="card-text">
                        <strong class="card-title">TEST!</strong>
                        <p class="card-content">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel voluptatum ducimus
                            aspernatur ipsam sit mollitia dolorem architecto, accusamus ad cum fuga deleniti nam aperiam, nobis
                            excepturi. Consequatur dolores obcaecati dignissimos?</p>
                    </div>
                    <ul class="card-tags">
                        <li class="card-tag">tag1</li>
                        <li class="card-tag">tag2</li>
                        <li class="card-tag">tag3</li>
                    </ul>
                </a>
            </li>
            <li class="card">
                <a href="">
                    <div>
                        <img class="card-image" src="./images/시그니처---백엔드-1.png" alt="">
                    </div>
                    <div class="card-text">
                        <strong class="card-title">TEST!</strong>
                        <p class="card-content">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel voluptatum ducimus
                            aspernatur ipsam sit mollitia dolorem architecto, accusamus ad cum fuga deleniti nam aperiam, nobis
                            excepturi. Consequatur dolores obcaecati dignissimos?</p>
                    </div>
                    <ul class="card-tags">
                        <li class="card-tag">tag1</li>
                        <li class="card-tag">tag2</li>
                        <li class="card-tag">tag3</li>
                    </ul>
                </a>
            </li>

        </ul>
    </div>
</div>
<div class="temp"></div>
<script type="myScript" id="test">
    <li class="card">
      <a href="">
        <div>
          <img class="card-image" src="./images/브릿지-썸네일.png" alt="">
        </div>
        <div class="card-text">
          <strong class="card-title">TEST!</strong>
          <p class="card-content">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vel voluptatum ducimus
            aspernatur ipsam sit mollitia dolorem architecto, accusamus ad cum fuga deleniti nam aperiam, nobis
            excepturi. Consequatur dolores obcaecati dignissimos?</p>
        </div>
        <ul class="card-tags">
          <li class="card-tag">tag1</li>
          <li class="card-tag">tag2</li>
          <li class="card-tag">tag3</li>
        </ul>
      </a>
    </li>
  </script>
</body>

</html>