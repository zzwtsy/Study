<template>
  <div class="container">
    <form class="d-flex w-75 m-auto">
      <input class="form-control me-2" type="text" placeholder="搜索" v-model.lazy="message">
      <button class="btn btn-primary w-25" type="button">搜索</button>
    </form>
    <p>{{ message }}</p>
    <table class="table table-bordered table-hover">
      <thead class="table-success">
        <tr>
          <th>schoolName</th>
          <th>email</th>
          <th>school</th>
          <th>display_order</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in schoolList" :key="item.name">
          <td>{{ item.name }}</td>
          <td>{{ item.email }}</td>
          <td>{{ item.school }}</td>
          <td>{{ item.display_order }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

export default {
  name: 'HelloWorld',
  data() {
    return {
      message: "test"
    }
  },
  props: {
    schoolList: {
      type: Array,
      default: function () {
        return []
      }
    }
  }
  // methods: {
  //   onClick() {
  //     test = true
  //   }
  // }
}
</script>