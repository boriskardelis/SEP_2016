var gulp = require('gulp');
var jshint = require('gulp-jshint');
var uglify = require('gulp-uglify');
//spajanje svih biblioteka iz bower components
var concatVendor = require('gulp-concat-vendor');

var minifyCss = require('gulp-minify-css');
var concatCss = require('gulp-concat-css');
var gNgFileSort = require('gulp-angular-filesort');
var concat = require('gulp-concat');
var print = require('gulp-print');


var vendorFiles=['jquery/dist/jquery.js',
	'angular/angular.js', 
    'angular-animate/angular-animate.js',
    'angular-bootstrap/ui-bootstrap-tpls.js',
    'angular-ui-router/release/angular-ui-router.js',
    'bootstrap/dist/js/bootstrap.js', 

    'angular-translate/angular-translate.js',
    'angular-local-storage/dist/angular-local-storage.js',
    'spin.js/spin.js',
    'angular-spinner/angular-spinner.js',
    'angular-loading-spinner/angular-loading-spinner.js'];

var addPathPrefix = function(orderedPaths){
	scriptPaths = [];
	for (var i = 0; i < orderedPaths.length; i++) {
		scriptPaths.push('bower_components/'+orderedPaths[i]); 
	}
	return scriptPaths;


}

//JSHint je alat koji analizira javaskript datoteke i skreće pažnju na loše prakse i problematičan kod
//Ne rešava sve probleme, ali može da bude koristan
gulp.task('lint', function() {
    gulp.src('app/**/*.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

//watch task poziva gulp.watch funkciju koja kao prvi parametar navodi koje datoteke posmatra,
//a kao drugi ima niz task-ova koje poziva kada se promeni neka od posmatranih datoteka
gulp.task('watch', function() {
	gulp.watch('app/**/*.js', ['lint']);
});

//ako gulpfile.js ima task sa imenom "default" onda će se on pozvati ako u terminalu ukucamo samo "gulp" bez imena nekog task-a
//u ovom slučaju vidimo da gulp.task funkcija ne mora da ima funkciju koja definiše zadatak, već neki task može samo da pozove druge task-ove
gulp.task('default', ['lint', 'watch']);


gulp.task('minify-css', function() {
	gulp.src('assets/css/*.css')
		.pipe(concatCss("all.min.css"))
        .pipe(minifyCss())
        .pipe(gulp.dest('dist'));
});

//Application js minification
gulp.task('scripts',function(){

	gulp.src(['app/**/*.js','!app/**/*.spec.js'])
		.pipe(gNgFileSort())
		.pipe(concat('all.min.js'))
		.pipe(uglify({mangle: false}))
		.pipe(gulp.dest('dist'));


});

//Vendor script minification
gulp.task('vendor-scripts',function(){

    gulp.src(addPathPrefix(vendorFiles))
		.pipe(print())
		.pipe(concatVendor('vendor.min.js'))
		.pipe(uglify())
	    .pipe(gulp.dest('dist'));

});

gulp.task('dist', ['minify-css', 'scripts', 'vendor-scripts']);