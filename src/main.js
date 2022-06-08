//引入vue
import Vue from 'vue'
//引入app
import App from './App.vue'

Vue.config.prodictionTip = false;

//创建vm
new Vue({
    el:'#app',
    render: h => h(App),
    beforeCreate() {
        Vue.prototype.$bus = this//创建全局事件总线
    },
    })