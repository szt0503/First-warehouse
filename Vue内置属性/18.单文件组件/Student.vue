
<template>
<!-- 组件的结构 -->
<div>
    <h2>学生姓名:{{name}}</h2>
    <h2>学生年龄:{{age}}</h2>
    <button @click = "showNum">点我看VM里的X值</button>
    </div>
</template>

<script>
// 组件交互相关的代码
export default {
            data() {
                return {
                    name:'小舞',
                    age:'18'
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