package com.userhabit.todo.todoapp;

import android.app.Application;

import io.userhabit.service.Userhabit;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * 디바이스 구분자 랜덤 생성 기능
         * Userhabit에서는 각각의 디바이스 구분을 위한 Android에서 제공하는 Android_ID를 사용합니다.
         * 해당 Android_ID 사용에 관하여 정책에 따라 해당 값을 수집하지 않기 위해서 아래와 같은 함수를 통해서 임의값으로 대체 가능합니다.
         */
        //Userhabit.enableDeviceRandomID();

        /**
         * 세션 종료 시간 설정하기
         * Userhabit SDK는 앱이 백그라운드로 넘어간 이 후
         * 특정 시간 동안 활성화 하지 않을 경우 세션을 종료 합니다.
         * 해당 세션의 기본값은 10초이며,
         * 세션의 시간을 변경이 필요할 경우 아래 API 호출
         */
        //Userhabit.setSessionEndTime(10);

        /**
         * 특정 Activity화면들을 제외하기
         * Activity안의 화면 중 화면의 가치가 없는 Activity들을
         * 화면수집 제외를 원할 경우 아래 API호출
         **/
        /*ArrayList<Class<? extends Activity>> list = new ArrayList<>();
        list.add(MainActivity.class);
        Userhabit.setExcludingClasses(list);*/

        /**
         * 화면 자동수집 해제
         * 아래의 API호출 할 경우,
         * 사용자가 직접 화면을 수동으로 수집하여야 합니다.
         **/
        //Userhabit.setManualActivityMode(true);

        /**
         * 디버그 모드 활성화 하기
         * 유저해빗 수집 과정의 로그 및 스크린샷 수집 모드를 활용 하실 수 있습니다.
         **/
        Userhabit.setDebug(true);

        /**
         * API14이상 자동수집.
         * SDK 구동을 위한 API 호출
         * 자동 수집을 시작 합니다.
         **/
        Userhabit.start(this, "dev_410b6692e8f7ad1fb6867145be2137621a88b819"); //real
//        Userhabit.start(this, "dev_7e136d0e62cef582cc7f22b3108ee840ff798d59"); //dev
    }
}
