# Logly

Logly is a Log-tool for Android.


# How to include

Add the library to your module **build.gradle**:

```gradle
dependencies {
    compile 'com.zql.android:logly:1.2'
}
```
# usage

1. Global Tag
```java
Logly.setGlobalTag(new Logly.Tag( Logly.FLAG_THREAD_NAME,"logly",Logly.DEBUG));
Logly.v("    v"); //hide
Logly.i("    i"); //hide
Logly.d("    d"); //show
Logly.w("    w"); //show
Logly.e("    e"); //show
```
2. Partial Tag
```java
Logly.d(new Logly.Tag(Logly.FLAG_NONE,"logly",Logly.DEBUG),"     d");
```

3. hide log output
```java
Logly.d(new Logly.Tag(Logly.FLAG_INVISIBLE,"logly",Logly.DEBUG),"     d");
```
#License

     Copyright 2016 zhangqinglian

  	Licensed under the Apache License, Version 2.0 (the "License");
  	you may not use this file except in compliance with the License.
  	You may obtain a copy of the License at

	     http://www.apache.org/licenses/LICENSE-2.0

  	Unless required by applicable law or agreed to in writing, software
	  distributed under the License is distributed on an "AS IS" BASIS,
	  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	  See the License for the specific language governing permissions and
	  limitations under the License.
