var gulp = require('gulp');
var jshint = require('gulp-jshint');
var jscs = require('gulp-jscs');

//JSHint je alat koji analizira javaskript datoteke i skreće pažnju na loše prakse i problematičan kod
//Ne rešava sve probleme, ali može da bude koristan
gulp.task('lint', function() {
  gulp.src('app/**/*.js')
      .pipe(jshint())
      .pipe(jscs())
      .pipe(jshint.reporter('jshint-stylish' , {verbose: true}));
});

//watch task poziva gulp.watch funkciju koja kao prvi parametar navodi koje datoteke posmatra,
//a kao drugi ima niz task-ova koje poziva kada se promeni neka od posmatranih datoteka
gulp.task('watch', function() {
	gulp.watch('app/**/*.js', ['lint']);
});

//ako gulpfile.js ima task sa imenom "default" onda će se on pozvati ako u terminalu ukucamo samo "gulp" bez imena nekog task-a
//u ovom slučaju vidimo da gulp.task funkcija ne mora da ima funkciju koja definiše zadatak, već neki task može samo da pozove druge task-ove
gulp.task('default', ['lint', 'watch']);