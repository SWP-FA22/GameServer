import {createRouter, createWebHistory} from 'vue-router';

import Home from './pages/Home.vue';
import Login from './pages/Login.vue';
import NotFound from './pages/NotFound.vue'


const routes = [
    {
        path: '/',
        alias : '/home',
        component : Home
    },
    {
        path: '/login',
        component : Login
    },
    {
        path : '/:notFound(.*)',
        component : NotFound

    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
    scrollBehavior(to , from , savedPosition) {
        if(savedPosition) {
            return savedPosition;
        }
    }
});

export default router;