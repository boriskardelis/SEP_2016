// Karma configuration
// Generated on Mon Feb 13 2017 13:56:16 GMT+0100 (Central Europe Standard Time)

module.exports = function(config) {
  config.set({

    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: '../',


    // frameworks to use
    // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
    frameworks: ['jasmine'],


    // list of files / patterns to load in the browser
    files: [
    'bower_components/angular/angular.js',
    'bower_components/angular-mocks/angular-mocks.js',
    'bower_components/jquery/dist/jquery.js',
    'bower_components/angular-animate/angular-animate.js',
    'bower_components/angular-bootstrap/ui-bootstrap-tpls.js',
    'bower_components/angular-ui-router/release/angular-ui-router.js',
    'bower_components/bootstrap/dist/js/bootstrap.js',
    'bower_components/checklist-model/checklist-model.js',
    'bower_components/angular-translate/angular-translate.js',
    'bower_components/angular-local-storage/dist/angular-local-storage.js',
    'bower_components/spin.js/spin.js',
    'bower_components/angular-spinner/angular-spinner.js',
    'bower_components/angular-loading-spinner/angular-loading-spinner.js',
    'app/appModule.js',
    'app/appConfig.js',
    'app/components/home/homeController.js',
    'app/components/buy/buyController.js',
    'app/components/about/aboutController.js',
    'app/components/navigation/navigationController.js',
    'app/components/url/urlController.js',
    'app/components/home/homeService.js',
    'app/components/buy/buyService.js',
    'app/components/url/urlService.js',
    'app/components/buy/buyDirective.js',
    'app/components/buy/buyAdditionalDirective.js',
    'app/components/buy/buyPersonsDirective.js',
    'app/components/buy/buyRadioDirective.js',
    'app/components/buy/loadingDirective.js',
    'app/components/buy/numbersOnlyDirective.js',
    'app/components/buy/uiSrefConditionDirective.js',

    'app/unit/mockService.js',
    //'bower_components/**/*.js',
    //'app/components/navigation/navigationController.js',
    //'app/components/buy/*.js',
    //'app/components/home/homeController.js',
    //'app/components/buy/buyController.js',
   // 'app/components/navigation/navigationController.spec.js',
    'app/components/buy/buyController.spec.js'


    ],


    // list of files to exclude
    exclude: [
    ],


    // preprocess matching files before serving them to the browser
    // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
    preprocessors: {
    },


    // test results reporter to use
    // possible values: 'dots', 'progress'
    // available reporters: https://npmjs.org/browse/keyword/karma-reporter
    reporters: ['progress'],


    // web server port
    port: 9876,


    // enable / disable colors in the output (reporters and logs)
    colors: true,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,


    // start these browsers
    // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
    browsers: ['Chrome'],


    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: false,

    // Concurrency level
    // how many browser should be started simultaneous
    //concurrency: Infinity
  })
}
