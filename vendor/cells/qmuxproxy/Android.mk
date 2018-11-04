# Copyright 2006 The Android Open Source Project

LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES:= \
	socketproxy.c \
	qmuxproxy.c

LOCAL_SHARED_LIBRARIES := \
	liblog \
	libcutils \
	librilutils

# temporary hack for broken vendor rils
LOCAL_WHOLE_STATIC_LIBRARIES := \
	librilutils_static

LOCAL_CFLAGS := -DRIL_SHLIB
#LOCAL_CFLAGS += -DANDROID_MULTI_SIM

ifeq ($(SIM_COUNT), 2)
    LOCAL_CFLAGS += -DANDROID_SIM_COUNT_2
endif

LOCAL_MODULE_OWNER := huawei
LOCAL_MODULE:= qmuxproxyd
LOCAL_MODULE_TAGS := optional

include $(BUILD_EXECUTABLE)
