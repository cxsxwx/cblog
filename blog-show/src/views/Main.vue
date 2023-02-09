<template>
  <div id="main">
    <div v-if="data.list.length == 0">
      <section id="intro">
        <router-link to="/main" class="logo">CXSXWX</router-link>
        <header>
          <h2>我们的未来也许并不完美</h2>
          <p>
            但不妨碍我们可以把现在的自己过好呀
            <router-link to="/main">CSW</router-link>
          </p>
        </header>
      </section>
      <article class="post">
        <header>
          <div class="title">
            <h2>还没有数据,稍等一下</h2>
            <p>还没有还没有还没有数据</p>
          </div>
        </header>
      </article>
    </div>
    <!-- 有数据时展示 -->
    <div v-else>
      <div id="wrapper">
        <div>
          <div v-for="(item, index) in data.list" :key="index">
            <article class="post">
              <header>
                <div class="title">
                  <h2>
                    <router-link :to="`/single?id=${item.id}`">{{
                      item.title
                    }}</router-link>
                  </h2>
                  <p>{{ item.intro }}</p>
                </div>
                <div class="meta">
                  <time class="published"
                    ><img
                      src="../assets/img/time.png"
                      width="13px"
                      height="13px"
                      alt=""
                    />{{ item.postedTime }}</time
                  >
                  <a href="#" class="author"
                    ><span class="name">cxsxwx</span
                    ><img src="../assets/img/001.jpg" alt=""
                  /></a>
                </div>
              </header>
              <router-link :to="`/single?id=${item.id}`" class="image featured"
                ><img src="../assets/img/01.jpg" alt=""
              /></router-link>
              <div class="file-over">
                <div class="file" v-html="item.mfile"></div>
              </div>
              <footer>
                <ul class="actions">
                  <li>
                    <router-link
                      :to="`/single?id=${item.id}`"
                      class="button large"
                      >继续阅读</router-link
                    >
                  </li>
                </ul>
                <ul class="stats">
                  <li><a href="#">一般</a></li>
                  <li>
                    <div>
                      <img
                        src="../assets/img/outline-heart.png"
                        width="13px"
                        height="13px"
                        alt=""
                      />
                      {{ item.love }}
                    </div>
                  </li>
                  <li>
                    <div>
                      <img
                        src="../assets/img/outline-eye.png"
                        width="13px"
                        height="13px"
                        alt=""
                      />{{ item.pview }}
                    </div>
                  </li>
                </ul>
              </footer>
            </article>
          </div>
          <ul class="actions pagination">
            <li>
              <a href="#" class="button large previous" @click="jCurrentPage()"
                >上一页</a
              >
            </li>
            <li>
              <a href="#" class="button large next" @click="pCurrentPage()"
                >下一页</a
              >
            </li>
          </ul>
        </div>

        <div>
          <section id="sidebar">
            <section id="intro">
              <router-link to="/main" class="logo">CXSXWX</router-link>
              <header>
                <h2>我们的未来也许并不完美</h2>
                <div class="table">
                  <ul>
                    <li>1</li>
                    <li>2</li>
                    <li>3</li>
                  </ul>
                </div>
                <div class="table">
                  <ul>
                    <li>文章数</li>
                    <li>分类数</li>
                    <li>标签数</li>
                  </ul>
                </div>
              </header>
            </section>

            <section>
              <div v-for="item in section.list">
                <div class="mini-posts">
                  <article class="mini-post">
                    <header>
                      <h3>
                        <router-link :to="`/single?id=${item.id}`">{{
                          item.title
                        }}</router-link>
                      </h3>
                      <time class="published"
                        ><img
                          src="../assets/img/time.png"
                          alt=""
                          width="15px"
                          height="15px"
                        />{{ item.postedTime }}</time
                      >
                      <a href="#" class="author"
                        ><img src="../assets/img/001.jpg" alt=""
                      /></a>
                    </header>
                    <router-link :to="`/single?id=${item.id}`" class="image"
                      ><img src="../assets/img/01.jpg" alt=""
                    /></router-link>
                  </article>
                </div>
              </div>
            </section>

            <section>
              <ul class="posts">
                <li v-for="item in section.list">
                  <article>
                    <header>
                      <h3>
                        <router-link :to="`/single?id=${item.id}`">{{
                          item.title
                        }}</router-link>
                      </h3>
                      <time class="published"
                        ><img
                          src="../assets/img/time.png"
                          alt=""
                          width="15px"
                          height="15px"
                        />{{ item.postedTime }}</time
                      >
                    </header>
                    <router-link :to="`/single?id=${item.id}`" class="image"
                      ><img src="../assets/img/01.jpg" alt=""
                    /></router-link>
                  </article>
                </li>
              </ul>
            </section>
            <section class="blurb">
              <h2>关于</h2>
              <p>
                我的朋友，我的朋友，我的朋友。 这匹马既不像马，也不像马。
                Vivamus porttitor 这是一种巨大的敌意，是一种强烈的诅咒。
              </p>
              <ul class="actions">
                <li><a href="#" class="button">查看更多</a></li>
              </ul>
            </section>

            <section id="footer">
              <ul class="icons">
                <li>
                  <a href="#">qq</a>
                </li>
                <li>
                  <a href="#">WX</a>
                </li>
                <li>
                  <a href="#">phone</a>
                </li>

                <li>
                  <a href="#">email</a>
                </li>
              </ul>
              <p class="copyright">
                &copy; CXSXWX: <a href="#">blog</a>. 介绍: <a href="#">无</a>.
              </p>
            </section>
          </section>
        </div>
      </div>
    </div>
    <!-- 结束 -->
    <!-- 无数据时显示 -->

    <!-- 结束 -->
  </div>
</template>

<script setup>
import {
  onMounted,
  onUpdated,
  onUnmounted,
  getCurrentInstance,
  reactive,
} from "vue";
const { proxy } = getCurrentInstance();
let data = reactive({
  list: [],
});
var section = reactive({
  list: [],
});

var pagination = reactive({
  current: 1,
  size: 2,
  total: 0,
});

let getAll = () => {
  proxy.$axios
    .get("/blog/" + pagination.current + "/" + pagination.size)
    .then((res) => {
      pagination.size = res.data.data.size;
      pagination.current = res.data.data.current;
      pagination.total = res.data.data.total;
      data.list = res.data.data.records;
    });
};

let pCurrentPage = () => {
  pagination.current = pagination.current + 1;

  getAll();
};
let jCurrentPage = () => {
  pagination.current = pagination.current - 1;
  if (pagination.current <= 0) {
    pagination.current = 1;
    getAll();
  } else {
    getAll();
  }
};
let getSection = () => {
  proxy.$axios.get("/blog/" + 1 + "/" + 2).then((res) => {
    section.list = res.data.data.records;
  });
};

getSection();
getAll();
</script>

<style scoped>
li {
  list-style: none;
}
</style>