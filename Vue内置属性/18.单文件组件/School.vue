
<template>
<!-- 组件的结构 -->
<div>
    <h2>学校名称:{{name}}</h2>
    <h2>学校地址:{{address}}</h2>
    <button @click = "showNum">点我看VM里的X值</button>
    </div>
</template>

<script>
// 组件交互相关的代码
export default {
            data() {
                return {
                    name:'百科园',
                    address:'地球'
                }
            },
            methods: {
                showNum(){
                    console.log(this.x);
                }
            },
        }
</script>

<style>
/* 样式标签 */
.dmeo{
    background-color: orange;
}
</style>