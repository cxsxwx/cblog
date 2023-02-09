<template>
  <div>
    <div v-if="posts.list.length == 0">
      <div class="title">
        <h1>分类</h1>
        <h2>目前共有{{ category.list.length }}个分类</h2>
      </div>

      <div id="wrappers">
        <div class="category">
          <div class="fl">
            <ul>
              <li v-for="item in category.list">
                <a @click="getPosts(item)">{{ item.name }}</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div v-else>
      <div class="title">
        <h1>{{ posts.categoryName }} 分类</h1>
        <h2>当前分类下共有:{{ posts.list.length }} 篇文章</h2>
      </div>
      <div id="wrappers">
        <section>
          <ul class="posts">
            <li v-for="item in posts.list">
              <article>
                <header>
                  <h3>
                    <router-link
                      :to="`/single?id=${item.id}`"
                      class="font-size"
                      >{{ item.title }}</router-link
                    >
                  </h3>
                  <time class="published">{{ item.postedTime }}</time>
                </header>
              </article>
            </li>
          </ul>
        </section>
      </div>
    </div>
  </div>
</template>

<script setup>
import { getCurrentInstance, reactive } from "vue";
let category = reactive({
  list: [],
});
let posts = reactive({
  categoryName: "",
  list: [],
});
const { proxy } = getCurrentInstance();
let getPosts = (a) => {
  posts.categoryName = a.name;
  proxy.$axios.get("/blog/category/" + a.id).then((res) => {
    if (res.data.data != null) {
      posts.list = res.data.data;
    } else {
      console.log(当前分类下无文章);
    }
  });
};
let getCategoryAll = () => {
  proxy.$axios.get("/category/getAll").then((res) => {
    category.list = res.data.data;
  });
};
getCategoryAll();
</script>

<style scoped>
h1 {
  font-size: 30px;
}
.font-size {
  font-size: 15px;
}

#wrappers {
  padding-top: 0;
  justify-content: center;
}
.title {
  text-align: center;
}
ul {
  width: 700px;
}
.fl ul li {
  float: left;
}
li {
  list-style: none;
  margin: 10px;
}
</style>