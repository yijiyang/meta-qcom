SUMMARY = "QCOM Graphics package group"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN} = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'glvnd', 'qcom-adreno-egl', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'vulkan', 'qcom-adreno-vulkan', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opencl', 'qcom-adreno-cl', '', d)} \
"

