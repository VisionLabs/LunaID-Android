

#### как добавить в зависимость aar
см. lunaCamera/, lunaCore/ и settings.gradle.
положить .aar файлы в соответствующие папки и добавить эти папки как зависимости в settings.gradle.


#### как инициализировать Luna ID SDK
см. App


#### как добавить оверлей в камеру
добавить в свое приложение лейаут с именем vl_lunacamera_overlay.  
в нем может быть что угодно. например, фрагмент.  
см. OverlayFragment


#### как сделать оверлей статический
см. OverlayFragment + ViewportView


#### как получать ошибки распознавания лица
см. CameraOverlayDelegate и в нем подписку на события из камеры.


#### как сделать оверлей с динамической рамкой лица
см. OverlayFragment + FaceDetectionView + CameraOverlayDelegate


#### CameraOverlayDelegate и динамическая типизация через словари
события из камеры приходят через CameraOverlayDelegate в словарях.  
какие структуры могут прийтий в словарях - см. OverlayFragment.  
 

#### как добавить лицензию Platform
в своем приложении положить файл лицензии по пути src/main/assets/data/license.conf.  


### как перезаписать настройки mobileSDK
положить соответствующие файлы настроек по пути src/main/assets/data/.  


