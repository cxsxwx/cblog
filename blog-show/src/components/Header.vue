<template>
  <div>
    <header id="header">
      <h1><router-link to="/main">CXSXWX</router-link></h1>
      <nav class="links">
        <ul>
          <li><router-link to="/main">首页</router-link></li>
          <li><router-link to="/category">分类</router-link></li>
          <li><router-link to="/labels">标签</router-link></li>
          <li><router-link to="/posts">文章</router-link></li>
          <li><router-link to="/about">关于</router-link></li>
          <div class="bu">
            <a @click="this.music.a = !this.music.a">音乐</a>
          </div>
        </ul>
      </nav>
      <div class="wyy" v-show="music.a">
        <iframe
          frameborder="5px"
          border="0"
          marginwidth="0"
          marginheight="0"
          width="330"
          height="450"
          src="//music.163.com/outchain/player?type=0&id=5396302207&auto=1&height=430"
        ></iframe>
      </div>
    </header>
  </div>
</template>

<script setup>
import { reactive } from "@vue/reactivity";

var music = reactive({
  a: false,
});
</script>

<style scoped>
.bu {
  float: right;
  margin-right: 100px;
}
</style>