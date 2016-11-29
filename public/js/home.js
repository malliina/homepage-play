$(document).ready(function () {
//    $("#pimplink").tooltip({
//        'selector': '',
//        'placement': 'top'
//    });
    $("#pimplink").popover({
        'title': 'MusicPimp',
        'content': 'A music streaming solution.',
        'placement': 'top',
        'trigger': 'hover'
    });
    $("#gitlink").popover({
        'title': 'GitHub',
        'content': 'Code repository.',
        'placement': 'top',
        'trigger': 'hover'
    });
    $("#worklink").popover({
        'title': 'LinkedIn',
        'content': 'Work.',
        'placement': 'bottom',
        'trigger': 'hover'
    });
});
