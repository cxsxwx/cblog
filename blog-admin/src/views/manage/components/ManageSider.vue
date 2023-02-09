<template>
  <Menu active-name="1-2" theme="light" width="auto" :open-names="['1']">
    <div class="mtitle">
      <h1>后台博客管理</h1>
    </div>
    <MenuItem name="1-1" to="/index">
    <Icon type="ios-navigate"></Icon>首页</MenuItem>
    <MenuGroup title="文章管理">
      <Submenu name="2">
        <template slot="title">
          <Icon type="ios-paper"></Icon>
         文章管理
        </template>
        <MenuItem name="2-1" to="/saveBlog">发布文章</MenuItem>
        <MenuItem name="2-3" to='/blog'>文章列表管理</MenuItem>
      </Submenu>
    </MenuGroup>
    <MenuGroup title="分类管理">
      <MenuItem name="3" to="/type">
        <Icon type="ios-keypad"></Icon> 分类</MenuItem>
    </MenuGroup>
    <MenuGroup title="标签管理">
      <MenuItem name="4" to='/label'> <Icon type="ios-analytics"></Icon> 标签</MenuItem>
    </MenuGroup>
    <MenuGroup title="个人信息">
      <Submenu name="5">
        <template slot="title">
          <Icon type="logo-octocat" />
          个人信息
        </template>
        <MenuItem name="5-1">个人信息修改</MenuItem>
      </Submenu>
    </MenuGroup>
  </Menu>
</template>

<script>
export default {
  name: "mSider",
};
</script>

<style scoped>
.mtitle {
  height: 64px;
  background-color: #515a6e;
  text-align: center;
  line-height: 64px;
}
.mtitle h1 {
  color: #ffff;
}
</style>