// src/main/resources/META-INF/resources/service-worker.js

self.addEventListener('install', (event) => {
    console.log('[Service Worker] Installing Service Worker...');
    event.waitUntil(
      caches.open('offline-cache').then((cache) => {
        console.log('[Service Worker] Caching offline page');
        return cache.addAll([
          '/',
          'offline.html',
          'images/offline.png',
          // Add other resources you want to cache
        ]);
      })
    );
  });
  
  self.addEventListener('fetch', (event) => {
    console.log('[Service Worker] Fetching resource:', event.request.url);
    if (event.request.mode === 'navigate') {
      event.respondWith(
        fetch(event.request).catch(() => {
          console.log('[Service Worker] Network request Failed. Serving offline page');
          return caches.open('offline-cache').then((cache) => {
            return cache.match('offline.html');
          });
        })
      );
    } else {
      event.respondWith(
        caches.match(event.request).then((response) => {
          return response || fetch(event.request);
        })
      );
    }
  });