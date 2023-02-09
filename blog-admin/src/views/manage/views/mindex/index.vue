<template>
  <div>
    <div class="mtitle">
      <Breadcrumb :style="{ margin: '10px 0' }">
        <BreadcrumbItem to="/index"
          ><Icon type="ios-home" />博客管理首页</BreadcrumbItem
        >
      </Breadcrumb>
    </div>
    <Content
      :style="{ padding: '20px', minHeight: '550px', background: '#fff' }"
    >
      <div class="card">
        <Card
          style="
            background-color: #ff9900;
          "
          class="f"
        >
          <div style="font-size: 30px; color: #fff">
            <h1><Icon type="ios-paper-outline" />文章数量:{{blog.length}}</h1>
          </div>
        </Card>
        <Card
          style="
            background-color: #2d8cf0;
          "
          class="f"
        >
          <div style="font-size: 30px; color: #fff">
            <h1><Icon type="ios-paper-outline" />分类数量:{{type.length}}</h1>
          </div>
        </Card>
        <Card
          style="
            background-color: #19be6b;
          "
          class="f"
        >
          <div style="font-size: 30px; color: #fff">
            <h1><Icon type="ios-paper-outline" />标签数量:{{label.length}}</h1>
          </div>
        </Card>
        <Card
          style="
            background-color: #ed4014;
          "
          class="f"
        >
          <div style="font-size: 30px; color: #fff">
            <h1><Icon type="ios-paper-outline" />访问人数:666</h1>
          </div>
        </Card>
      </div>
    </Content>
  </div>
</template>

<script>
export default {
  name: "index",
  data(){
    return{
      blog:[],
      type:[],
      label:[],
    }
  },
  components:{
  },
  created() {
    this.getBlogAll();
    this.getTypeAll();
    this.getLabelAll();
  },
  methods: {

      getBlogAll() {
      this.$axios.get("/blog/getAllBlog").then((res) => {
        this.blog = res.data.data;
      });
    },
    getTypeAll() {
      this.$axios.get("/category/getAll").then((res) => {
        this.type = res.data.data;
      });
    },
    getLabelAll() {
      this.$axios.get("/label/getAll").then((res) => {
        this.label = res.data.data;
      });
    },
  },
};
</script>

<style>
.mtitle {
  text-align: center;
}
.mtitle a {
  font-size: 30px;
}

.card {
  margin: 10px 0;
  display: flex;
  align-items: center;
  justify-content: space-around;
  font-family: "Hiragino Sans GB";
  flex-wrap:wrap
}
.f {
  margin: 10px 0;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 600px;
  height: 150px;
  border-radius: 50px;
}
</style>