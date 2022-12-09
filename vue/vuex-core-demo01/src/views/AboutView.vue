<template>
  <div class="about">
    <h1>This is an about page</h1>
    <p>{{ getCounter }}</p>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(["getCounter"])
  }
}
</script>
