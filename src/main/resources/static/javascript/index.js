          var tag = document.createElement('script');
    
          tag.src = "https://www.youtube.com/iframe_api";
          var firstScriptTag = document.getElementsByTagName('script')[0];
          firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
    
          // 3. This function creates an <iframe> (and YouTube player)
          //    after the API code downloads.
          var player;
          function onYouTubeIframeAPIReady() {
            player = new YT.Player('player', {
          // height: '390',
          // width: '640',
          videoId: 'X5HLanjqj9E',
          playerVars: {
            autoplay: 1,
            playlist: 'X5HLanjqj9E',
            loop: 1,
            controls: 0,
            mute: 1
            // autohide: 1,
            // showinfo: 0
          },
            });
          }

document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.sidenav');
    var instances = M.Sidenav.init(elems, options);
  });