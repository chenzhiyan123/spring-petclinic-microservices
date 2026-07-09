package org.springframework.samples.petclinic.customers;

public final class PetValidate {
    // 合法字符正则：中文、英文、数字、·、-、_、空格
    private static final String VALID_CHAR_REGEX = "^[\\u4e00-\\u9fa5a-zA-Z0-9·_\\-\\s]+$";

    /**
     * 校验宠物名称
     * @param petName 待校验的宠物名称
     * @return 校验通过返回 null；校验失败返回具体错误信息
     */
    public static String validate(String petName) {
        // 1. 非空校验
        if (petName == null || petName.trim().isEmpty()) {
            return "petName can not be empty!";
        }

        // 2. 首尾空格校验
        if (!petName.equals(petName.trim())) {
            return "petName can start or end with space!";
        }

        // 3. 长度校验
        int length = petName.length();
        if (length < 2 || length > 20) {
            return "the length of petName need between 2 and 20!";
        }

        // 4. 合法字符校验
        if (!petName.matches(VALID_CHAR_REGEX)) {
            return "petName can only be chinese、english、number、space、·、-、_";
        }

        // 5. 禁止连续空格（可选）
        if (petName.contains("  ")) {
            return "petName can not contain continuous spaces";
        }
        // 校验通过
        return null;
    }

}
