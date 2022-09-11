<template>
  <div id="carouselExampleCaptions" class="carousel slide relative" data-bs-ride="carousel">
    <div class="carousel-indicators absolute right-0 bottom-0 left-0 flex justify-center p-0 mb-4">
      <button v-for="number in slides.length" :key="number" type="button" data-bs-target="#carouselExampleCaptions"
        :data-bs-slide-to="number - 1" class="currentSlide" :aria-label="'Slide ' +  number"></button>
    </div>
    <div class="carousel-inner relative w-full overflow-hidden">
      <div v-for="slide in slides" :key="slide.id" class="carousel-item relative float-left w-full">
        <img :src="slide.src" class="block w-full" alt="..." />
        <div class="carousel-caption hidden md:block absolute text-center">
          <h5 class="text-xl">{{slide.title}}</h5>
          <p>{{slide.content}}</p>
        </div>
      </div>
    </div>
    <button
      class="carousel-control-prev absolute top-0 bottom-0 flex items-center justify-center p-0 text-center border-0 hover:outline-none hover:no-underline focus:outline-none focus:no-underline left-0"
      type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
      <span class="carousel-control-prev-icon inline-block bg-no-repeat" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button
      class="carousel-control-next absolute top-0 bottom-0 flex items-center justify-center p-0 text-center border-0 hover:outline-none hover:no-underline focus:outline-none focus:no-underline right-0"
      type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
      <span class="carousel-control-next-icon inline-block bg-no-repeat" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>
</template>

<script>
export default {
  mounted() {
    let allSlide = [...document.querySelectorAll('.currentSlide')];
    allSlide[0].classList.toggle('active');
    allSlide[0].setAttribute('aria-current', true)


    let allSlideItem = [...document.querySelectorAll('.carousel-item')];
    allSlideItem[0].classList.toggle('active');

  },
  data() {
    return {
      slides: [
        {
          id: 1,
          src: 'https://mdbootstrap.com/img/Photos/Slides/img%20(15).jpg',
          title: 'First slide label',
          content: 'Some representative placeholder content for the first slide.'
        },
        {
          id: 2,
          src: 'https://mdbootstrap.com/img/Photos/Slides/img%20(22).jpg',
          title: 'Second slide label',
          content: 'Some representative placeholder content for the second slide.'
        },
        {
          id: 3,
          src: 'https://mdbootstrap.com/img/Photos/Slides/img%20(23).jpg',
          title: 'Third slide label',
          content: 'Some representative placeholder content for the third slide.'
        }

      ],
    };
  },
};
</script>

<style>

</style>
