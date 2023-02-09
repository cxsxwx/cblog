<template>
  <div>
    <div class="title">
      <div class="typing-demo">
        <p>关于作者</p>
        <div class="img">
          <img src="../assets/img/001.jpg" alt="" />
        </div>
        <!-- <span>
          本人现居住湖南株洲，于大二学生一名,热衷于开发技术,该blog为个人练习的一个项目。
          本项目采用的技术有：<br/>
          前端:<br/>
          展示页面：vue3,vue-router,vite,axios<br/>
          后台博客管理页面：vue2,iview,axios,vue-router,vue-cli,mavon-editor<br/>
          后端:springboot,mybatis-plus,mysql,文档工具：Knife4j,构建工具：maven,容器：SpringFramework
        </span>     -->
      </div>
    </div>
    <div id="wrappers"></div>
  </div>
</template>


<script setup>
</script>

<style scoped>
.title {
  display: flex;
  justify-content: center;
  text-align: center;
}
#wrappers {
  justify-content: center;
  padding-top: 10px;
}
.img img {
  width: 150px;
  height: 150px;
  border-radius: 50%;
}
p {
  font-size: 50px;
}
span{
    font-size: 20px;
    color: black;
    
}
.typing-demo{
    width: 600px;
}
</style>