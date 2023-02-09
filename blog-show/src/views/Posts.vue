<template>
  <div>
    <div class="title">
      <h1>文章</h1>
      <h2>当前共有{{ section.list.length }} 篇文章</h2>
    </div>
    <div id="wrappers">
      <section>
        <ul class="posts">
          <li v-for="item in section.list">
            <article>
              <header>
                <h3>
                  <router-link :to="`/single?id=${item.id}`">{{ item.title }}</router-link>
                </h3>
                <p>{{ item.intro }}</p>
                <time class="published">{{ item.postedTime }}</time>
              </header>
              <router-link :to="`/single?id=${item.id}`" class="image flt">
                <img src="../assets/img/01.jpg" alt="" />
              </router-link>
            </article>
          </li>
        </ul>
      </section>
    </div>
  </div>
</template>

<script setup>
import { getCurrentInstance, reactive } from "vue";
var section = reactive({
  list: [],
});
const { proxy } = getCurrentInstance();
let getSection = () => {
  proxy.$axios.get("/blog/getAllBlog").then((res) => {
    section.list = res.data.data;
  });
};
console.log(section);
getSection();
</script>

<style scoped>
h1 {
  font-size: 30px;
}
.posts {
  width: 900px;
}
.posts li {
  font-size: 15px;
}
.posts li h3 {
  font-size: 20px;
}
#wrappers {
  justify-content: center;
  padding-top: 10px;
}
.flt {
  margin-top: 15px;
  margin-left: 10px;
  font-size: 30px;
}
.title {
  text-align: center;
}
article {
  background-color: rgba(255, 255, 255, 0.5);
  border-radius: 10px;
}
ul.posts li {
  padding: 0;
  border-top: dotted 2px rgba(0, 0, 0, 0.3);
}
</style>