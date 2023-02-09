<template>
  <div class="div">
    <Menu mode="horizontal" theme="dark" active-name="1">
      <div class="layout-logo">cxsxwx</div>
      <div class="layout-nav">
        <MenuItem name="1" to='/index'>
          <Icon type="ios-navigate"></Icon>
          首页
        </MenuItem>
        <MenuItem name="2" to='/type'>
          <Icon type="ios-keypad"></Icon>
          分类
        </MenuItem>
        <MenuItem name="3" to='/label'>
          <Icon type="ios-analytics"></Icon>
          标签
        </MenuItem>
        <MenuItem name="4" to='/blog'>
          <Icon type="ios-paper" ></Icon>
          文章
        </MenuItem>
        <Submenu name="5">
          <template slot="title">
          <Avatar>csw</Avatar>
            cxsxwx
          </template>
          <MenuItem name="5-1">
            <Button type="text" @click="value4 = true"
              >个人信息</Button
            ></MenuItem
          >
          <MenuItem name="5-2">
            <Button type="text" @click="modal6 = true"
              >退出登录</Button
            ></MenuItem
          >
        </Submenu>
      </div>
    </Menu>
    <Modal v-model="modal6" title="登出"  @on-ok="logot()">
      <p>确定要退出登录吗？</p>
    </Modal>
    <Drawer :closable="false" width="500" v-model="value4">
      <h1>个人信息</h1>
      <p>简介</p>
      <div class="demo-drawer-profile">
        <Row>
          <Col span="12"> 名字:cxsxwx</Col>
          <Col span="12"> 邮箱地址:480809834@qq.com </Col>
        </Row>
        <Row>
          <Col span="12"> 所在城市: 湖南 </Col>
          <Col span="12"> 出生地:中国 </Col>
        </Row>
        <Row>
          <Col span="12"> 生日:2003年1月20日 </Col>
        </Row>
        <Row>
          <Col span="10"></Col>
          <Col span="4">每天开心哦</Col>
          <Col span="10"></Col>
        </Row>
      </div>
      <Divider />
    </Drawer>
  </div>
</template>

<script>
export default {
  name: "mHeader",
  data() {
    return {
      value4: false,
      modal6: false,
    };
  },
  methods:{
    logot(){
      this.$router.push("/login");
      this.$Message.info("已退出登录");
    }
  }
};
</script>

<style>
.layout-logo {
  border-top: 2px solid #fff;
  border-bottom: 2px solid #fff;
  color: #fff;
  text-align: center;
  line-height: 26px;
  font-size: 25px;

}
</style>