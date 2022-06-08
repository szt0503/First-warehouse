<template>
  <transition name="todo" appear>
    <li>
        <label>
            <input type="checkbox" :checked="todo.done" @change="cc(todo.id)"/>

            <!-- <input type="checkbox" v-model="todo.done"/> -->
            <span v-show="!todo.isEdit">{{todo.title}}</span>
            <input 
            type="text" 
            v-show="todo.isEdit" 
            :value="todo.title" 
            @blur="blur(todo,$event)"
            ref="inputtitle"
            >
        </label>
        <button class="btn btn-danger" @click="del(todo.id)">删除</button>
        <button v-show="!todo.isEdit" class="btn btn-edit" @click="edit(todo)">编辑</button>
    </li>
  </transition>
</template>

<script>
import pubsub from 'pubsub-js'
export default {
    name:'Item',
    //声明接收todo对象
    props:['todo'],
    methods: {
        cc(id){
           //通知App组件将对应的todo对象的done值取反
            // this.checkTodo(id)
            this.$bus.$emit('checkTodo',id)

        },


        
        //删除
        del(id){
            if(confirm('确定删除吗?')){
                //原生写法
                // this.deleteTodo(id)

                //全局事件总线发泄
                //  this.$bus.$emit('deleteTodo',id)

                //消息订阅与发布写法
                pubsub.publish('deleteTodo',id)
            }
        },


        //编辑
        edit(todo){

            if(todo.isEdit){
                todo.isEdit = true
            }else{
            this.$set(todo,'isEdit',true)
            }

            //nextTick在下一次DOM更新结束后执行其指定的回调
            //也可以加定时器实现
            this.$nextTick(function(){
            this.$refs.inputtitle.focus()
            })
        },
        //失去焦点回调(真正执行修改逻辑)
        blur(todo,e){
            todo.isEdit = false
            if(!e.target.value.trim()) return
            this.$bus.$emit('updateTodo',todo.id,e.target.value)
        }
    },
}
</script>

<style scoped>
li{
    list-style: none;
    height: 36px;
    line-height: 36px;
    padding-left: 0 5px;
    border-bottom: 1px solid #ddd;
}

li label{
    float: left;
    cursor: pointer;
}
li label li input{
    vertical-align: middle;
    margin-right: 6px;
    position: relative;
    top: -1px;
}
li button{
    float: right;
    display: none;
    margin-top: 3px;
}
li::before{
    content: initial;
}

li:last-child{
    border-bottom: none;
}


li:hover{
    background-color: #ddd;
}
li:hover button{
    display: block;
}
.todo-enter-active{
        animation: szt 1s;
}
.todo-leave-active{
    animation: szt 1s reverse;
} 
    /* 动画 */
@keyframes szt {
    from{
        transform: translateX(100%);
    }
    to{
        transform: translateX(0px);
    }
}
</style>