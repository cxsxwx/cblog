<template>
  <div>
    <Breadcrumb :style="{ margin: '24px 0' }">
      <BreadcrumbItem to="/index">首页</BreadcrumbItem>
      <BreadcrumbItem>文章管理</BreadcrumbItem>
      <BreadcrumbItem>发表文章</BreadcrumbItem>
    </Breadcrumb>
    <Content
      :style="{ padding: '20px', mixHeight: '800px', background: '#fff' }"
    >
      <Form ref="form" :model="bm.blogPosts" label-position="left" inline>
        <FormItem label="标题:">
          <Input
            v-model="bm.blogPosts.title"
            placeholder="标题"
            style="width: 400px"
          ></Input>
          <div class="button"></div>
        </FormItem>

            <FormItem label="类别:">
              <Select v-model="bm.blogPosts.category" style="width: 400px">
                <Option
                  v-for="item in category"
                  :value="item.id"
                  :key="item.id"
                  >{{ item.name }}</Option
                >
              </Select>
            </FormItem>

 
        <div class="mackDown">
          <mavon-editor v-model="bm.blogPosts.content" @change="change" />
        </div>
          <div class="label">
            <div class="labels">
              <FormItem label="标签">
                <CheckboxGroup v-model="bm.mlabels" style="width:800px">
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
        <Drawer
          title="文章属性设置"
          v-model="ddd"
          width="400"
          :mask-closable="false"
        >
                <FormItem label="简介:">
          <Input
            v-model="bm.blogPosts.intro"
            type="textarea"
            placeholder="Enter something..."
          ></Input>
        </FormItem>

          <Col span="24">
            <Upload multiple type="drag" name="img" action="/blog/saveBlog">
              <div style="padding: 20px 0">
                <Icon
                  type="ios-cloud-upload"
                  size="52"
                  style="color: #3399ff"
                  :before-upload="handleUpload"
                  :format="['jpg','jpeg','png']"
                ></Icon>
                <p>封面上传</p>
              </div>
            </Upload>
          </Col>



          <Col span="6"> </Col>
          <FormItem>
            <Button type="primary" long @click="ddd = false">完成</Button>
          </FormItem>
        </Drawer>

        <FormItem>
          <Button type="success" long @click="ddd = true">文章属性设置</Button>
        </FormItem>
        <FormItem>
          <Button type="primary" long @click="saveBlog()">发布</Button>
        </FormItem>
      </Form>
    </Content>
  </div>
</template>

<script>
export default {
  name: "SaveBlog",
  data() {
    return {
      ddd: false,
      bm: {
        blogPosts: {
          title: "",
          author: "",
          intro: "",
          content: "",
          category: "",
          mfile: "",
        },
        mlabels: [],
      },

      category: {},
      label: {},
    };
  },
  created() {
    this.getCategoryAll();
    this.getLabelAll();
  },
  methods: {
    getCategoryAll() {
      this.$axios.get("/category/getAll").then((res) => {
        this.category = res.data.data;
      });
    },
    getLabelAll() {
      this.$axios.get("/label/getAll").then((res) => {
        this.label = res.data.data;
      });
    },
    saveBlog() {
      console.log(this.bm.blogPosts);
      this.$axios.post("/blog/saveBlog", this.bm).then((res) => {
        if (res) {
          this.$Message.success("发布成功");
          console.log(this.bm.blogPosts.mfile);
          this.bm.blogPosts = "";
        }
      });
      console.log(this.bm);
    },
    change(md, html) {
      this.bm.blogPosts.mfile = html;
    },
    handleUpload(file) {
      // 选择文件后 这里判断文件类型 保存文件 自定义一个keyid 值 方便后面删除操作
      let keyID = Math.random().toString().substr(2);
      file["keyID"] = keyID;
      // 保存文件到总展示文件数据里
      this.bm.blogPosts.push(file);
      // 保存文件到需要上传的文件数组里
      this.uploadFile.push(file);
    },
  },
};
</script>

<style>
.mackDown {
  max-height: 300px;
  margin-bottom: 20px;
}
.v-note-wrapper {
  z-index: 1 !important;
}
.mackDown {
  max-height: 300px;
  overflow: auto;
}
.labels {
  max-width: 300px;
}
.label {
  overflow: auto;
}
</style>