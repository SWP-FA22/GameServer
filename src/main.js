import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import VueSmoothScroll from 'v-smooth-scroll'
import 'tw-elements';

import router from './router';

const app = createApp(App)

app.use(router);
app.use(VueSmoothScroll , {
    duration : 400,
    updateHistory : true
})

app.mount('#app')
