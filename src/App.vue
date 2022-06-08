<template>
  <div id="root">
    <div class="todo-container">
      <div class="todo-wrap">
        <Top @rec="rec"/>
        <List :todos="todos"/>
        <Down :todos="todos" @checkAllTodo="checkAllTodo" @clearAllTodo="clearAllTodo"/>
      </div>
    </div>
  </div>
</template>

<script>
//引入组件
import pubsub from 'pubsub-js'
import Top from './components/Top'
import List from './components/List'
import Down from './components/Down'
export default {
    name:'App',
    components:{Top,List,Down},
    data() {
        return {
            todos:[
                {id:'0001',title:'吃饭',done:false},
                {id:'0002',title:'睡觉',done:false},
                {id:'0003',title:'打游戏',done:false},
                {id:'0004',title:'玩女人',done:false},
            ]
        }
    },
    methods: {
      //添加一个todo
      rec(x){
        this.todos.unshift(x)
      },
      //勾选or取消选择
      checkTodo(id){
        this.todos.forEach((todo)=>{//遍历todo
          if(todo.id === id) todo.done = !todo.done
        })
      },
      //删除一个todo
      deleteTodo(_,id){
        this.todos=this.todos.filter((todo)=>{
          return todo.id !== id
        })
      },
      //改数据
      updateTodo(id,title){
        this.todos.forEach((todo)=>{
          if(todo.id === id) todo.title = title
        })
      },
      //取消全选
      checkAllTodo(done){
        this.todos.forEach((todo)=>{
          todo.done = done
        })
      },
      //清除所有已经完成的todo
      clearAllTodo(){
       this.todos= this.todos.filter((todo)=>{
         return  !todo.done
        })
      }
    },

    //相当于props传参
    mounted(){
      this.$bus.$on('checkTodo',this.checkTodo)
      //全局总线写法
      // this.$bus.$on('deleteTodo',this.deleteTodo)
      this.$bus.$on('updateTodo',this.updateTodo)
      //消息订阅与发布写法
      this.pubId = pubsub.subscribe('deleteTodo',this.deleteTodo)
    },

    //解除绑定
    beforeDestroy() {
      this.$bus.$off('checkTodo')
      this.$bus.$off('updateTodo')
      // this.$bus.$off('deleteTodo')
      pubsub.unsubscribe(this.pubId)
    },
}
</script>

<style>
  body{
    background: #fff;
  }
  .btn{
    display: inline-block;
    padding: 4px 12px;
    margin-bottom: 0;
    font-size: 14px;
    line-height: 20px;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    box-shadow: inset 0 1ox 0 rgba(255,255,255,0.2),0 1px 2px rgba(0,0,0,0.05);
  }
  .btn-danger{
    columns: #fff;
    background-color: #da4f49;
    border: 1px solid #bd362f;
  }
  .btn-edit{
    columns: #fff;
    background-color: skyblue;
    border: 1px solid skyblue;
  }
  .btn-danger:hover{
    color: #fff;
    background-color: #bd362f;
  }
  .btn:focus{
    outline: none;
  }
  .todo-container{
    width: 600px;
    margin: 0 auto;
  } 
  .todo-container .todo-wrap{
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
  }
</style>