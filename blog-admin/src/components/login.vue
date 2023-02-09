<template>
  <div class="login">
    <div class="from">
      <Form ref="form" :model="form" :rules="ruleInline">
        <div class="logo">
          <p>cxsxwx</p>

          <span>后台博客管理</span>
        </div>

        <FormItem prop="user">
          <Input
            type="text"
            v-model="form.username"
            placeholder="用户名"
            style="width: 300px"
          >
            <Icon type="ios-person-outline" slot="prepend"></Icon>
          </Input>
        </FormItem>
        <FormItem prop="password">
          <Input
            type="password"
            v-model="form.password"
            placeholder="密码"
            style="width: 300px"
          >
            <Icon type="ios-lock-outline" slot="prepend"></Icon>
          </Input>
        </FormItem>
        <FormItem>
          <div class="bu">
            <Button type="primary" @click="onLoginClick()" long>登录</Button>
          </div>
        </FormItem>
      </Form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        username:'admin',
      },
    };
  },
  methods: {
    onLoginClick() {
      if (this.form.username != null &&this.form.username !='' || this.form.password != null&& this.form.password != '') {
        if (this.form.username === "admin") {
          if (this.form.password === "123456") {
            this.$router.push("/index");
            this.$Message.success("欢迎回来");
          } else {
            this.$Message.error("用户名或密码错误！！！");
          }
        } else {
          this.$Message.error("账号不存在");
        }
      }else{
          this.$Message.error('>-<！请输入账号密码！！！')
      }
    },
  },
};
</script>

<style>
.login {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #515a6e;
}
.from {
  text-align: center;
  display: flex;
  justify-content: center;
  /* align-items: center; */
  width: 400px;
  height: 500px;
  border-radius: 30px;
  background-color: aliceblue;
}
.logo {
  margin: 50px 0 40px 0;
  font-size: 40px;
}
.logo p {
  border-top: 1px solid #515a6e;
  border-bottom: 1px solid #515a6e;
}
</style>