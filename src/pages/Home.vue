<template>
    <div>
        <the-header />
        <slide-show />
        <about-us />
        <game-image />
        <about-us />
        <the-footer />
    </div>
</template>

<script>
import TheHeader from '../components/layout/TheHeader.vue'
import SlideShow from '../components/layout/home/SlideShow.vue'
import AboutUs from '../components/layout/home/AboutUs.vue'
import GameImage from '../components/layout/home/GameImage.vue'
import TheFooter from '../components/layout/TheFooter.vue'

export default {
    components: {
        TheHeader,
        SlideShow,
        AboutUs,
        GameImage,
        TheFooter
    }
}
</script>

<style>

</style>