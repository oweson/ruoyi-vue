import request from '@/utils/request'

// 查询高校终极版列表
export function listSchoolall(query) {
  return request({
    url: '/system/schoolall/list',
    method: 'get',
    params: query
  })
}

// 查询高校终极版详细
export function getSchoolall(id) {
  return request({
    url: '/system/schoolall/' + id,
    method: 'get'
  })
}

// 新增高校终极版
export function addSchoolall(data) {
  return request({
    url: '/system/schoolall',
    method: 'post',
    data: data
  })
}

// 修改高校终极版
export function updateSchoolall(data) {
  return request({
    url: '/system/schoolall',
    method: 'put',
    data: data
  })
}

// 删除高校终极版
export function delSchoolall(id) {
  return request({
    url: '/system/schoolall/' + id,
    method: 'delete'
  })
}

// 导出高校终极版
export function exportSchoolall(query) {
  return request({
    url: '/system/schoolall/export',
    method: 'get',
    params: query
  })
}