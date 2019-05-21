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


Vue.component('individual-comment', {
  template: 
  `<li> {{ commentpost }} </li>`,
  props: ['commentpost']
});

new Vue({
  el: '#message-board',
  data: {
    newComment: '',
    comments: [
      'Looks great Julianne!',
      'I love the sea',
      'Where are you at?'
    ]
  },
  methods: {
    methods: {
      deleteOne: function () {
          this.comments.pop()
      }
    },
    addComment: function () {
      if (this.newComment.trim() != "") {
        this.comments.push(this.newComment)
        this.newComment = ''
      }
    }
  }
});