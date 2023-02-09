<template>
  <div>
    <div v-if="posts.list.length == 0">
      <div class="title">
        <h1>标签</h1>
        <h2>目前共有{{ label.list.length }}个标签</h2>
      </div>

      <div id="wrappers">
        <div class="fl">
          <ul>
            <li v-for="item in label.list">
              <a @click="getPosts(item)">{{ item.name }}</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div v-else>
      <div class="title">
        <h1>{{ posts.labelsName }} 标签</h1>
        <h2>当前标签下共有:{{ posts.list.length }} 篇文章</h2>
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
let label = reactive({
  list: [],
});

let posts = reactive({
  labelsName: "",
  list: [],
});
const { proxy } = getCurrentInstance();

let getLabelAll = () => {
  proxy.$axios.get("/label/getAll").then((res) => {
    label.list = res.data.data;
  });
};
let getPosts = (a) => {
  posts.labelsName = a.name;
  proxy.$axios.get("/blog/labels/" + a.id).then((res) => {
    if (res.data.data != null) {
      posts.list = res.data.data;
    } else {
      console.log(当前标签下无文章);
    }
  });
};
getLabelAll();
</script>
<style scoped>
h1 {
  font-size: 30px;
}
.font-size {
  font-size: 15px;
}
#wrappers {
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