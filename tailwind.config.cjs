/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
    './node_modules/tw-elements/dist/js/**/*.js'
  ],
  theme: {
    extend: {
      colors : {
      }
    },
    fontFamily : {
      'display': ['Oswald'],
      'body': ['"Open Sans"',],
    }
  },
  plugins: [
    require('tw-elements/dist/plugin')
  ],
}
