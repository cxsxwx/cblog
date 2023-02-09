<template>
  <div>
    <Breadcrumb :style="{ margin: '24px 0' }">
      <BreadcrumbItem to="/index">首页</BreadcrumbItem>
      <BreadcrumbItem>文章管理</BreadcrumbItem>
    </Breadcrumb>
    <div class="k">
      <Content
        :style="{
          padding: '20px',
          minHeight: '700px',
          maxHeight: '700px',
          background: '#fff',
        }"
      >
        <div class="table">
          <Table border :columns="title" :data="data6" show-context-menu>
            <template slot-scope="{ row }" slot="name">
              <strong>{{ row.name }}</strong>
            </template>
            <template slot-scope="{ row}" slot="action">
              <Button
                type="primary"
                size="small"
                style="margin-right: 5px"
                @click="updateBlog(row)"
                >修改</Button
              >
              <Button type="error" size="small" @click="remove(row)"
                >删除</Button
              >
            </template>
            <template slot="contextMenu">
              <DropdownItem @click.native="handleContextMenuEdit"
                >查看更多</DropdownItem
              >
            </template>
          </Table>
        </div>
      </Content>
    </div>
  </div>
</template>

<script>
export default {
  name: "Blog",
  data() {
    return {
      title: [
        {
          title: "#",
          key: "id",
          type: "index",
        },
        {
          title: "文章标题",
          key: "title",
        },
        {
          title: "作者",
          key: "author",
        },
        {
          title: "点赞数",
          key: "love",
        },
        {
          title: "浏览数",
          key: "pview",
        },
        {
          title: "发布时间",
          key: "postedTime",
        },
        {
          title: "最后修改时间",
          key: "updateTime",
        },
        {
          title: "操作",
          slot: "action",
          width: 150,
          align: "center",
        },
      ],
      data6: [],
    };
  },
  created() {
    this.getAll();
  },
  methods: {
    getAll() {
      this.$axios.get("/blog/getAllBlog").then((res) => {
        this.data6 = res.data.data;
      });
    },
    remove(row) {
      this.$Modal.confirm({
        title: "删除操作",
        content: "<p>确定删除吗，该操作不可逆</p>",
        onOk: () => {
          this.$axios.delete("/blog/deleteBlog/" + row.id).then(() => {
            this.$Message.success("删除成功");
            this.getAll();
          });
        },
        onCancel: () => {
          this.$Message.info("取消操作");
        },
      });
    },
    updateBlog(row){
        this.$router.push({
          path:'/updateBlog',
          query:{id:row.id}
        })
      }
  },
};
</script>

<style>
.k {
  overflow: auto;
}
</style>