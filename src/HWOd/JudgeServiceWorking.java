package HWOd;

import java.util.*;

/**
 * @author skpeng
 * @version 1.0
 * @description 题目描述
 * <p>
 * 某系统中有众多服务，每个服务用字符串（只包含字母和数字，长度<=10）唯一标识，服务间可能有依赖关系，如A依赖B，则当B故障时导致A也故障。
 * 依赖具有传递性，如A依赖B，B依赖C，当C故障时导致B故障，也导致A故障。
 * 给出所有依赖关系，以及当前已知故障服务，要求输出所有正常服务。
 * 依赖关系：服务1-服务2 表示“服务1”依赖“服务2”
 * 不必考虑输入异常，用例保证：依赖关系列表、故障列表非空，且依赖关系数，故障服务数都不会超过3000，服务标识格式正常。
 * 输入描述:
 * 半角逗号分隔的依赖关系列表（换行）
 * 半角逗号分隔的故障服务列表
 * 输出描述:
 * 依赖关系列表中提及的所有服务中可以正常工作的服务列表，用半角逗号分隔，按依赖关系列表中出现的次序排序。
 * 特别的，没有正常节点输出单独一个半角逗号。
 * 示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * a1-a2,a5-a6,a2-a3
 * a5,a2
 * 输出
 * a6,a3
 * 说明
 * a1依赖a2，a2依赖a3，所以a2故障，导致a1不可用，但不影响a3；a5故障不影响a6。
 * 所以可用的是a3、a6，在依赖关系列表中a6先出现，所以输出:a6,a3。
 * 示例2  输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * a1-a2
 * a2
 * 输出
 * ,
 * 说明
 * a1依赖a2，a2故障导致a1也故障，没有正常节点，输出一个逗号。
 * @date 2022/9/10
 */
public class JudgeServiceWorking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        String[] arr = s.split(",");
        String[] arr1 = s1.split(",");
        List<String> values = new LinkedList<>();
        for (String s2 : arr1) {
            values.add(s2);
        }
        Set<String> result = new LinkedHashSet<>();
        for (String param : arr) {
            String before = param.substring(0, 2);
            String after = param.substring(3);
            if (values.contains(after)) {
                if (!values.contains(before)) {
                    values.add(before);
                }
            } else {
                result.add(after);
                if (values.contains(before) && result.contains(before)) {
                    result.remove(before);
                }
            }
        }
        String sResult = "";
        if (result.size() == 0) {
            sResult = ",";
        } else {
            for (String s2 : result) {
                sResult += "," + s2;
            }
            sResult = sResult.substring(1);
        }
        System.out.println(sResult);
    }

}
