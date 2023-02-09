<template>
  <div>
    <Breadcrumb :style="{ margin: '24px 0' }">
      <BreadcrumbItem to="/index">首页</BreadcrumbItem>
      <BreadcrumbItem>标签管理</BreadcrumbItem>
    </Breadcrumb>
    <Content
      :style="{ padding: '20px', maxHeight: '600px',mixHeight:'600px', background: '#fff' }" class="content"
    >
      <Form :model="form" inline>
        <FormItem>
          <Input type="text" v-model="form.name" placeholder="新增标签">
            <Icon type="md-add-circle" slot="prepend" />
          </Input>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="saveLabel()">提交</Button>
        </FormItem>
      </Form>
      <Table border :columns="columns12" :data="data6" max-height="500">
        <template slot-scope="{ row, index }" slot="name">
          <Input type="text" v-model="bname" v-if="editIndex === index" />
          <span v-else>{{ row.name }}</span>
        </template>
        <template slot-scope="{ row, index }" slot="action">
          <div v-if="editIndex === index">
            <Button @click="handleSave(row)" type="success">保存</Button>
            <span style="margin:5px"></span>
            <Button @click="editIndex = -1" type="error">取消</Button>
          </div>
          <div v-else>
            <Button @click="handleEdit(row, index)" type="info">操作</Button>
            <span style="margin:5px"></span>
            <Button @click="remove(row, index)" type="error">删除</Button>
          </div>
        </template>
      </Table>
    </Content>
  </div>
</template>

<script>
export default {
  name: "label",
  data() {
    return {
      form: {
        name:''
      },
      modal1: "false",
      bname: "",
      columns12: [
        {
          title: "#",
          key: "id",
          type:'index',
        },
        {
          title: "类名",
          slot: "name",
        },
        {
          title: "操作",
          slot: "action",
          width: 200,
          align: "center",
        },
      ],
      data6: [],
      editIndex: "-1",
    };
  },
  created() {
    this.getAll();
  },
  methods: {
    getAll() {
      this.$axios.get("/label/getAll").then((res) => {
        this.data6 = res.data.data;
      });
    },
    saveLabel() {
      this.$axios.post("/label/saveLabel", this.form).then((res) => {
        if (res) {
          this.$Message.success("添加成功");
          this.form.name='';
          this.getAll();
        } else {
          this.$Message.error("程序出错了，请联系管理员");
        }
      });
    },
    remove(row) {
      this.$Modal.confirm({
        title: "删除操作",
        content: "<p>确定删除吗，该操作不可逆</p>",
        onOk: () => {
          this.$axios.delete("/label/DeleteLabel/" + row.id).then(() => {
            this.$Message.success("删除成功");
            this.getAll();
          });
        },
        onCancel: () => {
          this.$Message.info("取消操作");
        },
      });
    },
    handleEdit(row, index) {
      this.$axios.get("/label/getById/" + row.id).then((res) => {
        this.bname = res.data.data.name;
        this.editIndex = index;
      });
    },
     handleSave(row) {
      this.$axios
        .put("/label/updateLabel?id=" + row.id + "&name=" + this.bname)
        .then((res) => {
          if (res) {
            this.$Message.success("修改成功");
            this.editIndex = -1;
            this.getAll();
          } else {
            this.$Message.error("修改失败");
          }
        });
    },
  },
};
</script>

<style>
  .content{
    overflow: auto;
  }
</style>