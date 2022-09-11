<template>
    <div>
        <the-header />
        <login-component />
    </div>
</template>

<script>
import TheHeader from '../components/layout/TheHeader.vue';
import LoginComponent from '../components/layout/account/LoginComponent.vue';
export default {
    components: {
        TheHeader,
        LoginComponent
    }
}
</script>