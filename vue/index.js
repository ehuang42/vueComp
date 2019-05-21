var app = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue!'
  }
})


var app5 = new Vue({
  el: '#app-5',
  data: {
      message: 'Try this toggle',
      seen: false 
      // if true span
  },
  methods: {
    reverseMessage: function () {
      this.message = this.message.split('').reverse().join('')
    }
  }
})