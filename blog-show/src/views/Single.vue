<template>
  <div>
    <div id="wrappers">
      <Header/>
      <div id="main">
        <article class="post min-height">
          <header>
            <div class="title">
              <h2>
                <a href="#">
                  {{data.posts.blogPosts.title}}
                </a>
              </h2>
              <p>
                {{data.posts.blogPosts.intro}}
              </p>
            </div>
            <div class="meta">
              <time class="published">
                <img src="../assets/img/time.png" alt="" width="15px" height="15px"/>
                {{data.posts.blogPosts.postedTime}}
              </time>
              <a href="#" class="author">
                <span class="name">
                  {{data.posts.blogPosts.author}}
                </span>
                <img src="../assets/img/001.jpg" alt=""/>
              </a>
            </div>
          </header>
	        <p>
            <span class="image featured">
              <img src="../assets/img/01.jpg" alt="" />
            </span>
            <div v-html="data.posts.blogPosts.mfile"></div>
          </p>
      <section id="footer">
        <ul class="icons">
          标签：
          <li v-for='item in data.posts.list'>
            <a href="#">{{item.name}}</a>
          </li>
        </ul>
        <p class="copyright">
           所属分类: <a href="#">{{data.posts.category.name}}</a>. 介绍:
          <a href="#">无</a>.
          <div>
            <img src="../assets/img/outline-eye.png" alt="" class="imgs"/>{{data.posts.blogPosts.pview}}
            <img src="../assets/img/outline-heart.png" alt="" class="imgs"/>{{data.posts.blogPosts.love}}
          </div>
        </p>
      </section>
        </article>
      </div> 
    </div>
  </div>
</template>

<script setup>
import { getCurrentInstance, onMounted, reactive, ref, onUpdated } from "vue";
import { useRoute, useRouter } from "vue-router";
import Header from "../components/Header.vue";

var data = reactive({
  posts: reactive({
    blogPosts: reactive({}),
    category: reactive({}),
    list: reactive({}),
  }),
});
const router = useRoute();
console.log(router);
const { proxy } = getCurrentInstance();
console.log(router.query.id);
let getPost = () => {
  let id = router.query.id;
  proxy.$axios.get("/blog/getBlog/" + id).then((res) => {
    data.posts = res.data.data;
    console.log(data.posts);
  });
};
getPost();
</script>

<style>
  .imgs{
    width: 10px;
    height: 10px;
    margin-left:20px;
  }
</style>