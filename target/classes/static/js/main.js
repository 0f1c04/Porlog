const searchEl= document.querySelector('.search');
const searchInputEl = searchEl.querySelector('input');

searchEl.addEventListener('click',function(){
 
  searchInputEl.focus();
});
searchInputEl.addEventListener('focus',function(){
  searchEl.classList.add('focused');
  searchInputEl.setAttribute('placeholder','통합검색');
});
searchInputEl.addEventListener('blur',function(){
  searchEl.classList.remove('focused');
  searchInputEl.setAttribute('placeholder','');
});



const fadeEls=document.querySelectorAll('.visual .fade-in');
fadeEls.forEach(function(fadeEl,index){
  gsap.to(fadeEl,1,{
    delay: (index+1)*.7,  //0.7,1.4,2.1,2.8
    opacity:1
  });
});


// new Swiper(선택자,옵션)
new Swiper('.notice-line .swiper-container',{
  direction:'vertical',
  autoplay:true,
  loop:true
});
new Swiper('.promotion .swiper-container',{
  // direction:'horizontal', 디렉션 기본값
  autoplay:{
    delay:5000
  },
  loop:true,//반복
  slidesPerView:3, //한번에 보여줄 슬라이드 개수
  spaceBetween:10, //슬라이드 사이 여백
  centeredSlides:true, //1번 슬라이드가 가운데보이기
  pagination:{
    el:'.promotion .swiper-pagination', //페이지 번호 요소 선택자
    clickable:true //사용자의 페이지 번호 요소 제어
  },
  navigation:{
    prevEl:'.promotion .swiper-prev',
    nextEl:'.promotion .swiper-next'
  }
});
const promotionEl=document.querySelector('.promotion');
const promotionToggleBtn=document.querySelector('.toggle-promotion');
let isHidePromotion = false;

promotionToggleBtn.addEventListener('click',function(){
  isHidePromotion=!isHidePromotion
  if(isHidePromotion){
    //숨김 처리!
    promotionEl.classList.add('hide');
  }else{
    //보임 처리!
    promotionEl.classList.remove('hide');
  }
});
const thisYear =document.querySelector('.this-year');
thisYear.textContent=new Date().getFullYear();

