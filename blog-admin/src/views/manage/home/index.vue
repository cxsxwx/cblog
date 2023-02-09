<template>
  <div class="layout">
    <Layout>
      <Sider hide-trigger :style="{ background: '#fff' }">
            <mSider />
      </Sider>
      <Layout>
        <Header>
            <mHeader />
        </Header>
        <Layout :style="{ padding: '0 24px 24px' }">
            <mContent />
        </Layout>
            <Footer class="layout-footer-center">
                2022-3-5 &copy; cxsxwx
            </Footer>
      </Layout>
    </Layout>
  </div>
</template>

<script>
import mHeader from "../components/ManageHeader.vue";
import mSider from "../components/ManageSider.vue";
import mContent from "../cotent";

export default {
  name: "Home",
  components: {
    mHeader,
    mSider,
    mContent,
  },
};
</script>

<style >
.layout { 
  border: 1px solid #d7dde4;
  background: #f5f7f9;
  position: relative;
  border-radius: 4px;
  overflow: hidden;
  height: 100vh;
}
.layout-logo {
  width: 100px;
  height: 30px;
  background: #5b6270;
  border-radius: 3px;
  float: left;
  position: relative;
  top: 15px;
  left: 20px;
}
.layout-nav {
  width: 550px;
  margin: 0 auto;
  margin-right: 15px;
}
.layout-footer-center {
  text-align: center;
  padding: 12px;
}
.ivu-layout-sider-children {
  height: 100vh;
}

</style>