DESCRIPTION = "Tiny ramdisk image with firmware files"

# Do not install anything by default
PACKAGE_INSTALL = ""

PACKAGE_INSTALL:qcom-armv8a = " \
    packagegroup-dragonboard410c-firmware \
    packagegroup-dragonboard820c-firmware \
    packagegroup-dragonboard845c-firmware \
    packagegroup-rb1-firmware \
    packagegroup-rb2-firmware \
    packagegroup-rb3gen2-firmware \
    packagegroup-rb5-firmware \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'wireless-regdb-static', '', d)} \
"

BAD_RECOMMENDATIONS = " \
    hexagon-dsp-binaries-qcom-db820c-adsp \
    hexagon-dsp-binaries-thundercomm-db845c-adsp \
    hexagon-dsp-binaries-thundercomm-db845c-cdsp \
    hexagon-dsp-binaries-thundercomm-db845c-sdsp \
    hexagon-dsp-binaries-thundercomm-rb1-adsp \
    hexagon-dsp-binaries-thundercomm-rb2-adsp \
    hexagon-dsp-binaries-thundercomm-rb2-cdsp \
    hexagon-dsp-binaries-thundercomm-rb5-adsp \
    hexagon-dsp-binaries-thundercomm-rb5-cdsp \
    hexagon-dsp-binaries-thundercomm-rb5-sdsp \
"

require initramfs-firmware-image.inc
