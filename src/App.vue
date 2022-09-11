<template>
  <div>
    <router-view v-slot="{Component}">
      <transition name="app" mode="out-in" >
        <component :is="Component" />
      </transition>
    </router-view>
  </div>
</template>

<script>
export default {

}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html {
  scroll-behavior: smooth;
}

.app-enter-from,
.app-leave-to {
  opacity: 0;
}

.app-enter-active {
  transition: opacity .3s ease-out;
}

.app-leave-active {
  transition: opacity .3s ease-in;
}

.app-enter-to,
.app-leave-from {
  opacity: 1;
}
</style>