<template>
  <div class="hello">
    <table>
      <thead>
        <th>uid</th>
        <th>uname</th>
        <th>school</th>
      </thead>
      <tbody>
        <tr>
          <th>{{ user.uid }}</th>
          <th>{{ user.uname }}</th>
          <th>{{ user.school }}</th>
        </tr>
      </tbody>
    </table>
    <hr>
    <table>
      <thead>
        <th>name</th>
        <th>email</th>
        <th>school</th>
        <th>display</th>
      </thead>
      <tbody>
        <tr v-for="item in schoolInfo" :key="item.name">
          <th>{{ item.name }}</th>
          <th>{{ item.email }}</th>
          <th>{{ item.school }}</th>
          <th>{{ item.display }}</th>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import api from "../api/index"
export default {
  data() {
    return {
      schoolInfo: {},
      user: {}
    }
  },
  name: 'HelloWorld',
  mounted() {
    //get请求
    api.getSchoolInfo().then(res => {
      console.log(res);
      this.schoolInfo = res.data
    })
    //post
    api.getLoginInfo().then(res => {
      console.log(res);
      this.user = res.data.userInfo;
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello,
table {
  width: 650px;
  margin: 0 auto;
}

tr,
thead {
  text-align: left;
}
</style>
