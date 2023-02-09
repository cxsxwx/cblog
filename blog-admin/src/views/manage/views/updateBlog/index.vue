<template>
  <div>
    <Breadcrumb :style="{ margin: '24px 0' }">
      <BreadcrumbItem to="/index">首页</BreadcrumbItem>
      <BreadcrumbItem to='/blog'>文章管理</BreadcrumbItem>
      <BreadcrumbItem>修改文章</BreadcrumbItem>
    </Breadcrumb>
    <Content
      :style="{ padding: '20px', mixHeight: '800px', background: '#fff' }"
    >
      <Form ref="form" :model="bm.blogPosts" label-position="left">
        <FormItem label="标题:">
          <Input
            v-model="bm.blogPosts.title"
            placeholder="标题"
            style="width: 600px"
          ></Input>
          <div class="button"></div>
        </FormItem>
        <FormItem label="简介:">
          <Input
            v-model="bm.blogPosts.intro"
            type="textarea"
            placeholder="Enter something..."
          ></Input>
        </FormItem>

        <div class="mackDown">
          <mavon-editor v-model="bm.blogPosts.content" @change="change" />
        </div>

        <Drawer
          title="文章属性设置"
          v-model="ddd"
          width="400"
          :mask-closable="false"
        >
          <Col span="24">
            <Upload
              multiple
              type="drag"
              action="//jsonplaceholder.typicode.com/posts/"
            >
              <div style="padding: 20px 0">
                <Icon
                  type="ios-cloud-upload"
                  size="52"
                  style="color: #3399ff"
                ></Icon>
                <p>封面上传</p>
              </div>
            </Upload>
          </Col>
          <Col span="6">
            <FormItem label="作者:">
              <Input
                v-model="bm.blogPosts.author"
                placeholder="作者"
                style="width: 300px"
              ></Input>
            </FormItem>
          </Col>
          <Col span="6"> </Col>
          <Col span="6">
            <FormItem label="类别:">
              <Select v-model="bm.blogPosts.category" style="width: 300px">
                <Option
                  v-for="item in typeList"
                  :value="item.id"
                  :key="item.id"
                  :label="item.name"
                  ></Option
                >
              </Select>
            </FormItem>
          </Col>
          <div class="label">
            <div class="labels">
              <FormItem label="标签">
                <CheckboxGroup v-model="bm.mlabels">
                  <Checkbox
                    v-for="l in label"
                    :label="l.id" 
                    :value="l.name"
                    :key="l.id"
                    >{{ l.name }}</Checkbox
                  >
                </CheckboxGroup>
              </FormItem>
            </div>
          </div>
          <FormItem>
            <Button type="primary" long @click="ddd = false">完成</Button>
          </FormItem>
        </Drawer>

        <FormItem>
          <Button type="success" long @click="ddd = true">文章属性设置</Button>
        </FormItem>
        <FormItem>
          <Button type="primary" long @click="updateBlog()">修改</Button>
        </FormItem>
      </Form>
    </Content>
  </div>
</template>

<script>
export default {
  name: "updateBlog",
  data() {
    return {
      bm: {
        blogPosts: {
          title: "",
          author: "",
          intro: "",
          content: "",
          category: 0,
          mfile: "",
        },
        mlabels: [],
      },
      category:{},
      ddd: false,
      typeList: [],
      label: [],
    };
  },
  created() {
    console.log(this.$route.query.id);
    this.getById();
    this.getCategoryAll();
    this.getLabelAll();
  },
  methods: {
    getById() {
      console.log(this.$route.query.id);
      this.$axios.get("/blog/updateGetById/" + this.$route.query.id).then((res) => {
        this.bm = res.data.data;
        console.log(res.data.data);
        console.log(this.bm);
      });
    },
    getCategoryAll() {
      this.$axios.get("/category/getAll").then((res) => {
        this.typeList = res.data.data;
        console.log(this.typeList);
      });
    },
    getLabelAll() {
      this.$axios.get("/label/getAll").then((res) => {
        this.label = res.data.data;
      });
    },
    change(md, html) {
      this.bm.blogPosts.mfile = html;
    },
    updateBlog(){
      this.$axios.put('/blog/updateBlog',this.bm).then((res)=>{
          if(res){
            this.$Message.success('修改成功');
            this.$router.push('/blog');
          }else{
            this.$Message.error('修改失败');
          }
      })
    }
  },
};
</script>

<style>
</style>