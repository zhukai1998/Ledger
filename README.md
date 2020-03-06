# Ledger
- activity_main.xml 原版
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    >
    <data>
        <variable
            name="ad"
            type="com.zhukai.ledger.module.ad.vm.ADViewModel"
            >

        </variable>
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".module.ad.ui.ADActivity">

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/logo"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintBottom_toBottomOf="parent"
            />

        <TextView
            android:id="@+id/copyright"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/copyright"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            android:layout_marginBottom="@dimen/ad_dimen"
            />

        <TextView
            android:id="@+id/skip"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{ad.skipMessage}"
            android:onClick="@{ad.skip}"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            android:layout_marginRight="@dimen/ad_dimen"
            android:layout_marginTop="@dimen/ad_dimen"
            />
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>

```
